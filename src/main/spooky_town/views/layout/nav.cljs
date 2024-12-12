(ns spooky-town.views.layout.nav)

(defn nav []
  [:nav.border-b.border-gray-800
   [:div.max-w-8xl.mx-auto.px-4.sm:px-6.lg:px-8
    [:div.flex.justify-between.h-16
     [:div.flex
      [:div.flex-shrink-0.flex.items-center
       [:img.h-8.w-auto {:src "https://ai-public.creatie.ai/gen_page/logo_placeholder.png"
                         :alt "Logo"}]]
      [:div.hidden.sm:ml-6.sm:flex.sm:space-x-8
       [:a.border-custom.text-custom.border-b-2.inline-flex.items-center.px-1.pt-1.text-sm.font-medium
        {:href "#"} "홈"]
       [:a.border-transparent.text-gray-300.hover:border-gray-300.hover:text-gray-200.inline-flex.items-center.px-1.pt-1.border-b-2.text-sm.font-medium
        {:href "#"} "콘텐츠"]
       [:a.border-transparent.text-gray-300.hover:border-gray-300.hover:text-gray-200.inline-flex.items-center.px-1.pt-1.border-b-2.text-sm.font-medium
        {:href "#"} "이벤트"]
       [:a.border-transparent.text-gray-300.hover:border-gray-300.hover:text-gray-200.inline-flex.items-center.px-1.pt-1.border-b-2.text-sm.font-medium
        {:href "#"} "분석"]]]]]]) 