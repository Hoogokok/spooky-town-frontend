(ns spooky-town.views.dashboard
  (:require [re-frame.core :as rf]
            [spooky-town.components.nav :refer [nav]]
            [spooky-town.views.dashboard.layout :refer [dashboard-layout]]))

(defn dashboard []
  [:div.min-h-screen.bg-gray-900.text-gray-100
   [nav]
   [dashboard-layout]]) 