(ns spooky-town.views.layout
  (:require [re-frame.core :as rf]
            [spooky-town.views.layout.main :refer [main-layout]]))

(defn root []
  (let [current-route @(rf/subscribe [:current-route])]
    [main-layout
     (if-let [view (:view (:data current-route))]
       [view]
       [:<>
        [:div "Loading..."]])])) 