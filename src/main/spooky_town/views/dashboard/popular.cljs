(ns spooky-town.views.dashboard.popular)

(defn content-item [{:keys [image title views growth]}]
  [:div.flex.items-center
   [:div.w-12.h-12.rounded.bg-gray-700.flex-shrink-0
    [:img.w-full.h-full.object-cover.rounded
     {:src image :alt title}]]
   [:div.ml-4
    [:h3.text-sm.font-medium title]
    [:p.text-xs.text-gray-400 (str "조회수: " views)]]
   [:div.ml-auto.text-yellow-500
    [:i.fas.fa-arrow-up] (str " " growth "%")]])

(defn popular-contents []
  [:div.col-span-4.bg-gray-800.rounded-lg.p-6
   [:h2.text-lg.font-medium.mb-4 "인기 콘텐츠"]
   [:div.space-y-4
    [content-item {:image "https://creatie.ai/ai/api/search-image?query=Horror movie poster thumbnail with dark atmosphere"
                   :title "떠도는 그림자"
                   :views "45.2천"
                   :growth "23"}]
    [content-item {:image "https://creatie.ai/ai/api/search-image?query=Horror comic cover thumbnail with mysterious elements"
                   :title "크림슨 이야기 #5"
                   :views "32.8천"
                   :growth "18"}]]]) 