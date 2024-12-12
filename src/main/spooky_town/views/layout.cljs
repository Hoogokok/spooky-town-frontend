(ns spooky-town.views.layout
  (:require [re-frame.core :as rf]))

(defn main-layout []
  (let [name @(rf/subscribe [:name])
        loading? @(rf/subscribe [:loading?])]
    [:div.container
     [:h1 name]
     (when loading?
       [:div "Loading..."])])) 