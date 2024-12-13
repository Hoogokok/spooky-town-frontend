(ns spooky-town.api.core
  (:require [cljs-http.client :as http]
            [cljs.core.async :refer [<!]]
            [re-frame.core :as rf])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(def ^:private api-url "http://localhost:3000/api")

(defn- handle-error [status error-text]
  (let [error-type (case status
                    0 :network
                    404 :not-found
                    (if (>= status 500) :server :default))]
    (rf/dispatch [:api-error error-type error-text])))

(defn api-request [method endpoint & [opts]]
  (go
    (try
      (rf/dispatch [:set-loading true])
      (let [response (<! (http/request
                         (merge {:method method
                                :url (str api-url endpoint)
                                :with-credentials? false
                                :headers {"Content-Type" "application/json"}}
                               opts)))]
        (rf/dispatch [:set-loading false])
        (if (:success response)
          (:body response)
          (do
            (handle-error (:status response) (:error-text response))
            nil)))
      (catch js/Error e
        (handle-error 0 (.-message e))
        (rf/dispatch [:set-loading false])
        nil))))