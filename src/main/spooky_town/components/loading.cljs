(ns spooky-town.components.loading
  (:require [re-frame.core :as rf]))

(defn loading-spinner []
  [:div.animate-spin.rounded-full.h-8.w-8.border-4.border-gray-300.border-t-yellow-500])

(defn loading-overlay []
  (when @(rf/subscribe [:loading?])
    [:div.fixed.inset-0.bg-black.bg-opacity-50.flex.items-center.justify-center.z-50
     [loading-spinner]])) 