(ns spooky-town.db)

;; 애플리케이션의 초기 상태를 정의
;; 모든 클라이언트 상태 데이터는 이 단일 장소에서 관리됨
(def default-db
  {:name "Spooky Town"
   :loading? false
   :current-route nil
   :dashboard {:selected-period "today"
              :engagement nil
              :popular nil}}) 