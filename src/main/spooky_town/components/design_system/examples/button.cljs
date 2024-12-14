(ns spooky-town.components.design-system.examples.button
  (:require [reagent.core :as r]))

(defn button-examples []
  [:div
   ;; CSS 로드
   [:link {:rel "stylesheet" :href "/css/design-system/tokens/colors.css"}]
   [:link {:rel "stylesheet" :href "/css/design-system/tokens/typography.css"}]
   [:link {:rel "stylesheet" :href "/css/design-system/tokens/spacing.css"}]
   [:link {:rel "stylesheet" :href "/css/design-system/core/button.css"}]
   
   [:div.p-8
    [:h1.text-2xl.font-bold.mb-8 "Button Component"]
    
    ;; 컴포넌트 설명
    [:section.mb-8
     [:p.text-lg "기본적인 동작을 수행하는 버튼 컴포넌트입니다. Primary와 Secondary 스타일을 지원합니다."]]
    
    ;; 사용 예시
    [:section.mb-8
     [:h2.text-xl.font-semibold.mb-4 "Usage"]
     [:pre.bg-gray-800.p-4.rounded.mb-4
      [:code 
       "[:button.btn.btn-primary \"Primary Button\"]\n"
       "[:button.btn.btn-secondary \"Secondary Button\"]"]]
     [:div.flex.gap-4
      [:button.btn.btn-primary "Primary Button"]
      [:button.btn.btn-secondary "Secondary Button"]]]
    
    ;; 변형
    [:section.mb-8
     [:h2.text-xl.font-semibold.mb-4 "Variants"]
     [:div.grid.gap-4
      [:div
       [:h3.text-lg.mb-2 "Primary"]
       [:button.btn.btn-primary "Primary Button"]
       [:pre.bg-gray-800.p-2.rounded.mt-2
        [:code ".btn.btn-primary"]]]
      [:div
       [:h3.text-lg.mb-2 "Secondary"]
       [:button.btn.btn-secondary "Secondary Button"]
       [:pre.bg-gray-800.p-2.rounded.mt-2
        [:code ".btn.btn-secondary"]]]]]
    
    ;; 상태
    [:section.mb-8
     [:h2.text-xl.font-semibold.mb-4 "States"]
     [:div.grid.gap-4
      [:div
       [:h3.text-lg.mb-2 "Disabled"]
       [:button.btn.btn-primary {:disabled true} "Disabled Button"]
       [:pre.bg-gray-800.p-2.rounded.mt-2
        [:code "{:disabled true}"]]]]]]])
