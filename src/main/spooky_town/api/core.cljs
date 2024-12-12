(ns spooky-town.api.core
  (:require [cljs-http.client :as http]
            [cljs.core.async :refer [<!]]
            [re-frame.core :as rf])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(def ^:private api-url "http://localhost:3000/api")

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
          (throw (js/Error. (or (:error-text response) "API request failed")))))
      (catch js/Error e
        (rf/dispatch [:set-error (.-message e)])
        (rf/dispatch [:set-loading false])
        nil))))