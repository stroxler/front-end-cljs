(ns cc-vids.views
    (:require [re-frame.core :as re-frame]))

(def description
  "The brown bear is native to parts of northern Eurasia and
  North America. Its conservation status is currently \"Least Concern\".
  There are many subspecies, including the Atlas bear and the
  Himalayan brown bear.")

(def img-src
  "https://upload.wikimedia.org/wikipedia/commons/thumb/7/71/2010-kodiak-bear-1.jpg/440px-2010-kodiak-bear-1.jpg")

(def google-images
  "https://www.google.com/search?q=brown+bears&espv=2&biw=840&bih=905&site=webhp&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjKk-Lb3sDSAhWVHsAKHQ_oDiAQ_AUIBigB")

(def static-html
  [:div#container
   [:div#nav
    [:a {:href "#description"} "description"] [:text " "]
    [:a {:href "#photo"} "photo"] [:text " "]
    [:a {:href "#facts"} "facts"] [:text " "]]
   [:div#main
    [:h1 "The brown bear"]
    [:h2#description "Description"]
    [:p description]
    [:a {:href google-images} [:img#photo {:src img-src :alt "Image of Brown Bear"}]]
    [:br]
    [:a {:href "https://en.wikipedia.org/wiki/Brown_bear"} "Learn More"]
    [:h2#facts "Facts"]
    [:p "Here are some bear species:"
     [:ol#species
      [:li "Arctos"]
      [:li "Collarus"]
      [:li "Horribilis"]]
     "The following countries have the largest populations of brown bears:"
     [:ul#locations
      [:li "Russia"]
      [:li "United States, especially:"
       [:ul
        [:li "Alaska"]
        [:li "Wyoming"]
        [:li "Montana"]]]
      [:li "Canada"]]]
    ]])


(defn main-panel []
  (let [name (re-frame/subscribe [:name])]
    [:div
     static-html
     [:div "------------------"]
     [:div "Hiccup templating courtesey of " @name]
     ]))
