(ns spooky-town.components.design-system.examples.input
  (:require [reagent.core :as r]))

(defn input-examples []
  [:div
   ;; CSS 로드
   [:link {:rel "stylesheet" :href "/css/design-system/tokens/colors.css"}]
   [:link {:rel "stylesheet" :href "/css/design-system/tokens/typography.css"}]
   [:link {:rel "stylesheet" :href "/css/design-system/tokens/spacing.css"}]
   [:link {:rel "stylesheet" :href "/css/design-system/core/input.css"}]
   
   [:div.p-8
    [:h1.text-2xl.font-bold.mb-8 "Input Component"]
    
    ;; 컴포넌트 설명
    [:section.mb-8
     [:p.text-lg "사용자 입력을 받는 기본적인 입력 필드 컴포넌트입니다."]]
    
    ;; 사용 예시
    [:section.mb-8
     [:h2.text-xl.font-semibold.mb-4 "Usage"]
     [:pre.bg-gray-800.p-4.rounded.mb-4
      [:code 
       "[:input.input {:type \"text\" :placeholder \"Enter text...\"}]"]]
     [:div.w-64
      [:input.input {:type "text" :placeholder "Enter text..."}]]]
    
    ;; 변형
    [:section.mb-8
     [:h2.text-xl.font-semibold.mb-4 "Variants"]
     [:div.grid.gap-4
      [:div
       [:h3.text-lg.mb-2 "Basic Input"]
       [:input.input {:type "text" :placeholder "Basic input"}]
       [:pre.bg-gray-800.p-2.rounded.mt-2
        [:code ".input"]]]
      [:div
       [:h3.text-lg.mb-2 "Error State"]
       [:input.input.input-error {:type "text" :placeholder "Error input"}]
       [:pre.bg-gray-800.p-2.rounded.mt-2
        [:code ".input.input-error"]]]]]
    
    ;; 상태
    [:section.mb-8
     [:h2.text-xl.font-semibold.mb-4 "States"]
     [:div.grid.gap-4
      [:div
       [:h3.text-lg.mb-2 "Disabled"]
       [:input.input {:type "text" :disabled true :value "Disabled input"}]
       [:pre.bg-gray-800.p-2.rounded.mt-2
        [:code "{:disabled true}"]]]]]]]) 