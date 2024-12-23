(ns spooky-town.routes
  (:require [reitit.frontend :as rf]
            [reitit.frontend.easy :as rfe]
            [re-frame.core :as re-frame]
            [spooky-town.views.dashboard :as dashboard]
            [spooky-town.views.contents :as contents]
            [spooky-town.views.events :as events]
            [spooky-town.views.analytics :as analytics]
            [spooky-town.components.design-system.examples.button :refer [button-examples]]
            [spooky-town.components.design-system.examples.card :refer [card-examples]]
            [spooky-town.components.design-system.examples.input :refer [input-examples]]
            [spooky-town.components.design-system.examples.select :refer [select-examples]]
            [spooky-town.components.design-system.examples.modal :refer [modal-examples]]))

(def routes
  [["/"
    {:name :home
     :view dashboard/dashboard}]
   ["/contents"
    {:name :contents
     :view contents/main}]
   ["/events"
    {:name :events
     :view events/main}]
   ["/analytics"
    {:name :analytics
     :view analytics/main}]
   ["/design-system"
    ["/button" {:name :ds-button
                :view button-examples}]
    ["/card" {:name :ds-card
              :view card-examples}]
    ["/input" {:name :ds-input
               :view input-examples}]
    ["/select" {:name :ds-select
                :view select-examples}]
    ["/modal" {:name :ds-modal
               :view modal-examples}]]])

(defn on-navigate [new-match]
  (when new-match
    (re-frame/dispatch [:set-current-route new-match])))

(defn init-routes! []
  (rfe/start!
   (rf/router routes)
   on-navigate
   {:use-fragment false})) 