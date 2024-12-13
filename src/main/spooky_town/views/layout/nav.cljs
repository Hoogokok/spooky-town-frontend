(ns spooky-town.views.layout.nav
  (:require [re-frame.core :as rf]
            [reitit.frontend.easy :as rfe]))

(defn nav-link [route text]
  (let [current-route @(rf/subscribe [:current-route])
        active? (= (:name current-route) route)]
    [:a.inline-flex.items-center.px-1.pt-1.border-b-2.text-sm.font-medium
     {:href (rfe/href route)
      :class (if active?
               "border-yellow-500 text-yellow-500"
               "border-transparent text-gray-300 hover:border-gray-300 hover:text-gray-200")}
     text]))

(defn nav []
  [:nav.border-b.border-gray-800
   [:div.max-w-8xl.mx-auto.px-4.sm:px-6.lg:px-8
    [:div.flex.justify-between.h-16
     [:div.flex
      [:div.flex-shrink-0.flex.items-center
       [:img.h-8.w-auto {:src "https://ai-public.creatie.ai/gen_page/logo_placeholder.png"
                         :alt "Logo"}]]
      [:div.hidden.sm:ml-6.sm:flex.sm:space-x-8
       [nav-link :home "홈"]
       [nav-link :contents "콘텐츠"]
       [nav-link :events "이벤트"]
       [nav-link :analytics "분석"]]]]]]) 