(ns spooky-town.routes
  (:require [reitit.frontend :as rf]
            [reitit.frontend.easy :as rfe]
            [re-frame.core :as re-frame]
            [spooky-town.views.dashboard :as dashboard]
            [spooky-town.views.contents :as contents]
            [spooky-town.views.events :as events]
            [spooky-town.views.analytics :as analytics]))

(def routes
  [["/"
    {:name :home
     :view dashboard/main}]
   ["/contents"
    {:name :contents
     :view contents/main}]
   ["/events"
    {:name :events
     :view events/main}]
   ["/analytics"
    {:name :analytics
     :view analytics/main}]])

(defn on-navigate [new-match]
  (when new-match
    (re-frame/dispatch [:set-current-route new-match])))

(defn init-routes! []
  (rfe/start!
   (rf/router routes)
   on-navigate
   {:use-fragment false})) 