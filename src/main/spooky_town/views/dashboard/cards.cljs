(ns spooky-town.views.dashboard.cards
  (:require [re-frame.core :as rf]))

(defn popular-content-item [{:keys [image title views growth]}]
  [:div.flex.items-center
   [:div.w-12.h-12.rounded.bg-gray-700.flex-shrink-0
    [:img.w-full.h-full.object-cover.rounded
     {:src image
      :alt title}]]
   [:div.ml-4
    [:h3.text-sm.font-medium title]
    [:p.text-xs.text-gray-400 (str "조회수: " views)]]
   [:div.ml-auto.text-custom
    [:i.fas.fa-arrow-up] (str " " growth "%")]])

(defn upcoming-content-item [{:keys [icon title date]}]
  [:div.flex.items-center
   [:div.w-12.h-12.rounded.bg-gray-700.flex-shrink-0.flex.items-center.justify-center.text-custom
    [:i.fas {:class (case icon
                     :calendar "fa-calendar-alt"
                     :mask "fa-mask"
                     "fa-calendar-alt")
             :class-name "text-2xl"}]]
   [:div.ml-4
    [:h3.text-sm.font-medium title]
    [:p.text-xs.text-gray-400 date]]])

(defn popular-contents []
  [:div.bg-gray-800.rounded-lg.p-6
   [:h2.text-lg.font-medium.mb-4 "인기 배포 콘텐츠"]
   [:div.space-y-4
    [popular-content-item
     {:image "https://ai-public.creatie.ai/gen_page/horror1.jpg"
      :title "떠도는 그림자"
      :views "45.2천"
      :growth "23"}]
    [popular-content-item
     {:image "https://ai-public.creatie.ai/gen_page/horror2.jpg"
      :title "크림슨 이야기 #5"
      :views "32.8천"
      :growth "18"}]]])

(defn upcoming-contents []
  [:div.bg-gray-800.rounded-lg.p-6
   [:h2.text-lg.font-medium.mb-4 "예정된 콘텐츠"]
   [:div.space-y-4
    [upcoming-content-item
     {:icon :calendar
      :title "2024 공포영화 페스티벌"
      :date "2024년 3월 15-20일"}]
    [upcoming-content-item
     {:icon :mask
      :title "고딕 아트 전시회"
      :date "2024년 4월 5일"}]]]) 