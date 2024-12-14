(ns spooky-town.components.design-system.examples.modal
  (:require [reagent.core :as r]))

(defn modal-examples []
  (let [show-modal? (r/atom false)
        show-large-modal? (r/atom false)]
    (fn []
      [:div
       ;; CSS 로드
       [:link {:rel "stylesheet" :href "/css/design-system/tokens/colors.css"}]
       [:link {:rel "stylesheet" :href "/css/design-system/tokens/typography.css"}]
       [:link {:rel "stylesheet" :href "/css/design-system/tokens/spacing.css"}]
       [:link {:rel "stylesheet" :href "/css/design-system/core/modal.css"}]

       [:div.p-8
        [:h1.text-2xl.font-bold.mb-8 "Modal Component"]

        ;; 컴포넌트 설명
        [:section.mb-8
         [:p.text-lg "오버레이 형태로 콘텐츠를 표시하는 모달 컴포넌트입니다."]]

        ;; 사용 예시
        [:section.mb-8
         [:h2.text-xl.font-semibold.mb-4 "Usage"]
         [:pre.bg-gray-800.p-4.rounded.mb-4
          [:code
           "(let [show-modal? (r/atom false)]\n"
           "  [:div\n"
           "   [:button {:on-click #(reset! show-modal? true)} \"Open Modal\"]\n"
           "   (when @show-modal?\n"
           "     [:div.modal\n"
           "      [:div.modal-content\n"
           "       [:h2 \"Modal Title\"]\n"
           "       [:p \"Modal content...\"]\n"
           "       [:button {:on-click #(reset! show-modal? false)} \"Close\"]]])])"]]
         [:div.flex.gap-4
          [:button.btn.btn-primary
           {:on-click #(reset! show-modal? true)}
           "Open Basic Modal"]]]

        ;; 변형
        [:section.mb-8
         [:h2.text-xl.font-semibold.mb-4 "Variants"]
         [:div.grid.gap-4
          [:div
           [:h3.text-lg.mb-2 "Large Modal"]
           [:button.btn.btn-primary
            {:on-click #(reset! show-large-modal? true)}
            "Open Large Modal"]
           [:pre.bg-gray-800.p-2.rounded.mt-2
            [:code ".modal-content.modal-lg"]]]]]

        ;; 모달 렌더링
        (when @show-modal?
          [:div.modal
           [:div.modal-overlay {:on-click #(reset! show-modal? false)}]
           [:div.modal-content
            [:div.modal-header
             [:h2.modal-title "Basic Modal"]
             [:button.modal-close {:on-click #(reset! show-modal? false)} "×"]]
            [:div.modal-body
             [:p "This is a basic modal example."]]
            [:div.modal-footer
             [:button.btn.btn-secondary {:on-click #(reset! show-modal? false)} "Close"]]]])

        (when @show-large-modal?
          [:div.modal
           [:div.modal-overlay {:on-click #(reset! show-large-modal? false)}]
           [:div.modal-content.modal-lg
            [:div.modal-header
             [:h2.modal-title "Large Modal"]
             [:button.modal-close {:on-click #(reset! show-large-modal? false)} "×"]]
            [:div.modal-body
             [:p "This is a large modal example with more content."]
             [:p "It has multiple paragraphs and more space for content."]]
            [:div.modal-footer
             [:button.btn.btn-secondary {:on-click #(reset! show-large-modal? false)} "Close"]]]])]]))) 