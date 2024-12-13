(ns spooky-town.components.nav
  (:require [re-frame.core :as rf]))

(defn logo []
  [:div.flex-shrink-0.flex.items-center
   [:img.h-8.w-auto 
    {:src "https://ai-public.creatie.ai/gen_page/logo_placeholder.png"
     :alt "Logo"}]])

(defn nav-item [{:keys [href label active?]}]
  [:a.inline-flex.items-center.px-1.pt-1.border-b-2.text-sm.font-medium
   {:href href
    :class (if active?
            "border-custom text-custom"
            "border-transparent text-gray-300 hover:border-gray-300 hover:text-gray-200")}
   label])

(defn new-content-button []
  [:button.bg-custom.!rounded-button.px-4.py-2.text-black.font-medium.hover:bg-custom/90
   [:i.fas.fa-plus.mr-2] "새 콘텐츠 등록"])

(defn notification-button []
  [:button.p-2.text-gray-400.hover:text-gray-300
   [:i.fas.fa-bell.text-xl]])

(defn profile-button []
  [:div.ml-3.relative
   [:div.flex.items-center
    [:button.bg-gray-800.flex.text-sm.rounded-full.focus:outline-none
     [:img.h-8.w-8.rounded-full
      {:src "https://creatie.ai/ai/api/search-image?query=A professional profile photo with dark mysterious background suitable for horror content creator&width=32&height=32&orientation=squarish"
       :alt "User"}]]]])

(defn nav-actions []
  [:div.flex.items-center
   [new-content-button]
   [:div.ml-4.flex.items-center
    [notification-button]
    [profile-button]]])

(defn nav []
  [:nav.border-b.border-gray-800
   [:div.max-w-8xl.mx-auto.px-4.sm:px-6.lg:px-8
    [:div.flex.justify-between.h-16
     [:div.flex
      [logo]
      [:div.hidden.sm:ml-6.sm:flex.sm:space-x-8
       [nav-item {:href "#" :label "홈" :active? true}]
       [nav-item {:href "#" :label "배포 채널"}]
       [nav-item {:href "#" :label "콘텐츠 관리"}]
       [nav-item {:href "#" :label "구독자 분석"}]]]
     [nav-actions]]]]) 