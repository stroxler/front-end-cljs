(ns cc-vids.views
    (:require [re-frame.core :as re-frame]))

(def description
  "The brown bear is native to parts of northern Eurasia and
  North America. Its conservation status is currently \"Least Concern\".
  There are many subspecies, including the Atlas bear and the
  Himalayan brown bear.")

(def img-src
  {:in-forest
   "http://www.ophrysphotography.co.uk/slideshows/brownbear/medium/0004.jpg"
   :cubs
   "http://miriadna.com/desctopwalls/images/max/Brown-bears.jpg"
   })

(def google-images
  "https://www.google.com/search?q=brown+bears&espv=2&biw=840&bih=905&site=webhp&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjKk-Lb3sDSAhWVHsAKHQ_oDiAQ_AUIBigB")


(defn photo-as-link [img-src descr]
  [:a {:href google-images}
   [:img {:src img-src :alt descr
          :width "500px" :height "350px"}]])


(def static-html
  [:div#container
   [:div#header
    [:h1 "The brown bear"]]
   [:div#nav
    [:a {:href "#description"} "description"] [:text " "]
    [:a {:href "#photo"} "photo"] [:text " "]
    [:a {:href "#facts"} "facts"] [:text " "]]
   [:div#main
    [:h2#description "Description"]
    [:p description]
    [:a {:href "https://en.wikipedia.org/wiki/Brown_bear"} "Learn More"]
    [:h2#photos "Photos"]
    (photo-as-link (img-src :in-forest) "Bears in forest")
    [:br]
    (photo-as-link (img-src :cubs) "Bear Cubs")
    [:br]
    [:h2#facts "Facts"]
    [:p "Here are some bear species:"]
    [:ul#species
     [:li "Arctos"]
     [:li "Collarus"]
     [:li "Horribilis"]]
    [:p "The following countries have the largest populations of brown bears:"]
    [:ul#locations
     [:li "Russia"]
     [:li "United States, especially:"
      [:ul
       [:li "Alaska"]
       [:li "Wyoming"]
       [:li "Montana"]]]
     [:li "Canada"]]
    ]])


(defn main-panel []
  (let [name (re-frame/subscribe [:name])]
    [:div
     static-html
     [:div#re-frame "Hiccup templating courtesey of " @name]
     ]))
