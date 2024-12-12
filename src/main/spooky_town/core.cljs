(ns spooky-town.core
  (:require [reagent.dom :as rdom]
            [re-frame.core :as rf]
            [spooky-town.events]
            [spooky-town.subs]
            [spooky-town.views.layout :as layout]))

(defn ^:dev/after-load reload! []
  (rf/clear-subscription-cache!)
  (.log js/console "Code updated."))

(defn ^:export init []
  (rf/dispatch-sync [:initialize-db])
  (rdom/render [layout/main-layout]
              (.getElementById js/document "app"))) 