(ns spooky-town.events
  (:require [re-frame.core :as rf]
            [spooky-town.db :as db]))

;; 앱 초기화 시 기본 DB 상태를 설정하는 이벤트
(rf/reg-event-db
 :initialize-db
 (fn [_ _]
   db/default-db))

;; 로딩 상태를 변경하는 이벤트
(rf/reg-event-db
 :set-loading
 (fn [db [_ loading?]]
   (assoc db :loading? loading?)))

;; 현재 라우트를 설정하는 이벤트
(rf/reg-event-db
 :set-current-route
 (fn [db [_ route]]
   (assoc db :current-route route))) 