(ns spooky-town.views.layout
  (:require [re-frame.core :as rf]
            [spooky-town.views.layout.main :refer [main-layout]]))

(defn root []
  (let [name @(rf/subscribe [:name])
        loading? @(rf/subscribe [:loading?])]
    [main-layout
     [:div
      [:h1.text-2xl.font-bold name]
      (when loading?
        [:div "Loading..."])]])) 