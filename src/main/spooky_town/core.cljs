(ns spooky-town.core
  (:require [reagent.dom.client :as rdom]
            [re-frame.core :as rf]
            [spooky-town.routes :as routes]
            [spooky-town.views.layout :as layout]
            [spooky-town.events]
            [spooky-town.subs]))

(defonce root (rdom/create-root (.getElementById js/document "app")))

(defn ^:dev/after-load reload! []
  (rf/clear-subscription-cache!)
  (.log js/console "Code updated.")
  (rdom/render root [layout/root]))

(defn ^:export init []
  (rf/dispatch-sync [:initialize-db])
  (routes/init-routes!)
  (rdom/render root [layout/root])) 