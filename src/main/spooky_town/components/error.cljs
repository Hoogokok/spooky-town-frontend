(ns spooky-town.components.error
  (:require [re-frame.core :as rf]))

(def error-messages
  {:network "네트워크 연결을 확인해주세요."
   :server "서버 오류가 발생했습니다."
   :not-found "데이터를 찾을 수 없습니다."
   :default "오류가 발생했습니다."})

(defn error-banner []
  (when-let [error @(rf/subscribe [:error])]
    [:div.fixed.bottom-4.right-4.bg-red-500.text-white.px-4.py-3.rounded-lg.shadow-lg
     {:class "animate-fade-in"}
     [:div.flex.items-center
      [:i.fas.fa-exclamation-circle.mr-2]
      [:span (get error-messages (:type error) (:message error))]]
     [:button.absolute.top-2.right-2.text-white.hover:text-red-200
      {:on-click #(rf/dispatch [:clear-error])}
      [:i.fas.fa-times]]])) 