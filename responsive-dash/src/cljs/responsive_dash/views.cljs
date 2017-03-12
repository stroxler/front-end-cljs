(ns responsive-dash.views
    (:require [re-frame.core :as re-frame]))

(defn nav []
  [:nav [:ul [:li.selected "Main"] [:li "Secondary"] [:li "Tertiary"]]])


(defn news [& news-titles-and-content]
  [:div.news-container
   (into [:section.news]
         (for [[title content] news-titles-and-content]
           (do
             (js/console.log title)
             [:article.news-item
              [:div.title title]
              [:div.content content]])))])

(defn main-panel []
  (js/console.log (news ["thing" "value"]))
  (let [name (re-frame/subscribe [:name])]
    (fn []
      [:div.app
       [:div.header [:span [:em "FauxNews"] "Dashboard"]]
       [:div.main
        (nav)
        (news
         ["Big Announcement" "Something really big is happening... yep!"]
         ["Another Announcement" "A different thing is also happening."]
         ["Betty Announcement" [:div
                                [:p "Betty is watching a lot of videos, indeed."]
                                [:br]
                                [:p "She's a hard worker."]]])
        ]])))
