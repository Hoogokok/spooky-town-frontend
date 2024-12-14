(ns spooky-town.views.dashboard.cards
  (:require [re-frame.core :as rf]))

(defn popular-content-item [{:keys [image title views growth]}]
  [:div.card
   [:div.card-image
    [:img {:src image :alt title}]]
   [:div.card-content
    [:h3.card-title title]
    [:p.card-subtitle (str "조회수: " views)]]
   [:div.card-metrics
    [:i.fas.fa-arrow-up.card-icon]
    [:span (str " " growth "%")]]])

(defn upcoming-content-item [{:keys [icon title date]}]
  [:div.card
   [:div.card-image.flex.items-center.justify-center
    [:i.fas.card-icon
     {:class (case icon
              :calendar "fa-calendar-alt"
              :mask "fa-mask"
              "fa-calendar-alt")}]]
   [:div.card-content
    [:h3.card-title title]
    [:p.card-subtitle date]]])

(defn popular-contents []
  [:div.content-section
   [:h2.section-title "인기 배포 콘텐츠"]
   [:div.card-grid
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
  [:div.content-section
   [:h2.section-title "예정된 콘텐츠"]
   [:div.card-grid
    [upcoming-content-item
     {:icon :calendar
      :title "2024 공포영화 페스티벌"
      :date "2024년 3월 15-20일"}]
    [upcoming-content-item
     {:icon :mask
      :title "고딕 아트 전시회"
      :date "2024년 4월 5일"}]]]) 