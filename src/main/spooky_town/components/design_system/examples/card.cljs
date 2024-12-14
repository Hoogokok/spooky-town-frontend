(ns spooky-town.components.design-system.examples.card
  (:require [reagent.core :as r]))

(defn card-examples []
  [:div
   ;; CSS 로드
   [:link {:rel "stylesheet" :href "/css/design-system/tokens/colors.css"}]
   [:link {:rel "stylesheet" :href "/css/design-system/tokens/typography.css"}]
   [:link {:rel "stylesheet" :href "/css/design-system/tokens/spacing.css"}]
   [:link {:rel "stylesheet" :href "/css/design-system/core/card.css"}]
   
   [:div.p-8
    [:h1.text-2xl.font-bold.mb-8 "Card Component"]
    
    ;; 컴포넌트 설명
    [:section.mb-8
     [:p.text-lg "콘텐츠를 그룹화하고 구조화하는 카드 컴포넌트입니다."]]
    
    ;; 사용 예시
    [:section.mb-8
     [:h2.text-xl.font-semibold.mb-4 "Usage"]
     [:pre.bg-gray-800.p-4.rounded.mb-4
      [:code 
       "[:div.card\n"
       " [:div.card-header\n"
       "  [:h3.card-title \"Card Title\"]]\n"
       " [:div.card-content\n"
       "  \"Card content goes here.\"]]"]]
     [:div.card
      [:div.card-header
       [:h3.card-title "Example Card"]]
      [:div.card-content
       "This is an example card with a title and content."]]]
    
    ;; 변형
    [:section.mb-8
     [:h2.text-xl.font-semibold.mb-4 "Variants"]
     [:div.grid.gap-4
      [:div
       [:h3.text-lg.mb-2 "Basic Card"]
       [:div.card
        [:div.card-content "A simple card with only content."]]
       [:pre.bg-gray-800.p-2.rounded.mt-2
        [:code ".card"]]]
      [:div
       [:h3.text-lg.mb-2 "Card with Header"]
       [:div.card
        [:div.card-header
         [:h3.card-title "Card Title"]]
        [:div.card-content "A card with header and content."]]
       [:pre.bg-gray-800.p-2.rounded.mt-2
        [:code ".card > .card-header + .card-content"]]]]]]]) 