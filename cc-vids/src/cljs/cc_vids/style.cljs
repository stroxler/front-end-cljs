(ns cc-vids.style
  (:require [garden.core :as g]))


(defn update-css [css-str]
  (let [ style-tag-selector "#garden-css"
        style-tag (.querySelector js/document style-tag-selector)]
    (prn style-tag)
    (set! (.-innerHTML style-tag) css-str)))

(defn get-css []
  (g/css
   [:body {:font-family ["Roboto" "sans-serif"]
           :background-color "beige"}]
   [:ol#species {:color "brown"}]
   [:#locations {:color "green"}]))
