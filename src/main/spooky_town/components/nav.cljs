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

(defn mobile-nav-item [{:keys [href label active?]}]
  [:a.block.px-3.py-2.rounded-md.text-base.font-medium
   {:href href
    :class (if active?
            "bg-gray-900 text-white"
            "text-gray-300 hover:bg-gray-700 hover:text-white")}
   label])

(defn mobile-menu []
  (let [menu-open? @(rf/subscribe [:mobile-menu-open?])]
    [:div.sm:hidden
     ;; 햄버거 버튼
     [:button.inline-flex.items-center.justify-center.p-2.rounded-md.text-gray-400.hover:text-white.hover:bg-gray-700
      {:on-click #(rf/dispatch [:toggle-mobile-menu])}
      [:i.fas.fa-bars.h-6.w-6]]

     ;; 모바일 메뉴 패널 (z-index 및 위치 조정)
     [:div.fixed.inset-0.z-50
      {:class (if menu-open? "block" "hidden")}

      ;; 배경 오버레이 (z-index 조정)
      [:div.fixed.inset-0.bg-black.opacity-50
       {:on-click #(rf/dispatch [:toggle-mobile-menu])}]

      ;; 메뉴 컨텐츠 (위치 및 스타일 조정)
      [:div.fixed.top-0.right-0.h-full.w-64.bg-gray-800.shadow-xl.overflow-y-auto
       [:div.flex.items-center.justify-between.h-16.px-4.border-b.border-gray-700
        [:div.flex-shrink-0
         [:img.h-8.w-auto
          {:src "https://ai-public.creatie.ai/gen_page/logo_placeholder.png"
           :alt "Logo"}]]
        [:button.inline-flex.items-center.justify-center.p-2.rounded-md.text-gray-400.hover:text-white.hover:bg-gray-700
         {:on-click #(rf/dispatch [:toggle-mobile-menu])}
         [:i.fas.fa-times.h-6.w-6]]]

       [:div.px-2.pt-2.pb-3.space-y-1
        [mobile-nav-item {:href "#" :label "홈" :active? true}]
        [mobile-nav-item {:href "#" :label "배포 채널"}]
        [mobile-nav-item {:href "#" :label "콘텐츠 관리"}]
        [mobile-nav-item {:href "#" :label "구독자 분석"}]]]]]))

(defn new-content-button []
  [:button {:class "bg-custom !rounded-button px-4 py-2 text-black font-medium hover:bg-custom-90"}
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
   [:div.hidden.sm:block  ;; 모바일에서는 숨김
    [new-content-button]]
   [:div.ml-4.flex.items-center
    [notification-button]
    [profile-button]]])

(defn nav []
  [:nav.border-b.border-gray-800
   [:div.max-w-8xl.mx-auto.px-4.sm:px-6.lg:px-8
    [:div.flex.justify-between.h-16
     [:div.flex
      [logo]
      [:div.hidden.sm:ml-6.sm:flex.sm:space-x-8  ;; 데스크톱 메뉴
       [nav-item {:href "#" :label "홈" :active? true}]
       [nav-item {:href "#" :label "배포 채널"}]
       [nav-item {:href "#" :label "콘텐츠 관리"}]
       [nav-item {:href "#" :label "구독자 분석"}]]]
     [:div.flex.items-center
      [nav-actions]
      [mobile-menu]]]]])  ;; 모바일 메뉴 추가