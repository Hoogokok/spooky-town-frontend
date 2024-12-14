(ns spooky-town.components.design-system.examples.select
  (:require [reagent.core :as r]))

(defn select-examples []
  [:div
   ;; CSS 로드
   [:link {:rel "stylesheet" :href "/css/design-system/tokens/colors.css"}]
   [:link {:rel "stylesheet" :href "/css/design-system/tokens/typography.css"}]
   [:link {:rel "stylesheet" :href "/css/design-system/tokens/spacing.css"}]
   [:link {:rel "stylesheet" :href "/css/design-system/core/select.css"}]
   
   [:div.p-8
    [:h1.text-2xl.font-bold.mb-8 "Select Component"]
    
    ;; 컴포넌트 설명
    [:section.mb-8
     [:p.text-lg "옵션 목록에서 값을 선택할 수 있는 드롭다운 컴포넌트입니다."]]
    
    ;; 사용 예시
    [:section.mb-8
     [:h2.text-xl.font-semibold.mb-4 "Usage"]
     [:pre.bg-gray-800.p-4.rounded.mb-4
      [:code 
       "[:select.select\n"
       " [:option {:value \"1\"} \"Option 1\"]\n"
       " [:option {:value \"2\"} \"Option 2\"]]"]]
     [:div.w-64
      [:select.select
       [:option {:value ""} "Select an option..."]
       [:option {:value "1"} "Option 1"]
       [:option {:value "2"} "Option 2"]
       [:option {:value "3"} "Option 3"]]]]
    
    ;; 변형
    [:section.mb-8
     [:h2.text-xl.font-semibold.mb-4 "Variants"]
     [:div.grid.gap-4
      [:div
       [:h3.text-lg.mb-2 "Basic Select"]
       [:select.select
        [:option {:value ""} "Choose..."]
        [:option {:value "1"} "First Option"]
        [:option {:value "2"} "Second Option"]]
       [:pre.bg-gray-800.p-2.rounded.mt-2
        [:code ".select"]]]
      [:div
       [:h3.text-lg.mb-2 "Multiple Select"]
       [:select.select {:multiple true}
        [:option {:value "1"} "Option 1"]
        [:option {:value "2"} "Option 2"]
        [:option {:value "3"} "Option 3"]]
       [:pre.bg-gray-800.p-2.rounded.mt-2
        [:code ".select[multiple]"]]]]]
    
    ;; 상태
    [:section.mb-8
     [:h2.text-xl.font-semibold.mb-4 "States"]
     [:div.grid.gap-4
      [:div
       [:h3.text-lg.mb-2 "Disabled"]
       [:select.select {:disabled true}
        [:option "Disabled select"]]
       [:pre.bg-gray-800.p-2.rounded.mt-2
        [:code "{:disabled true}"]]]]]]]) 