(ns cc-vids.style
  (:require [garden.core :as g]))


(defn update-css [css-str]
  (let [ style-tag-selector "#garden-css"
        style-tag (.querySelector js/document style-tag-selector)]
    (prn style-tag)
    (set! (.-innerHTML style-tag) css-str)))

(defn color [shade hue]
  (let [colors
        {:brown {:light "#f9f2ec"
                 :medium "#edd7c5"
                 :dark "#734b26"
                 }}]
    (-> colors (hue) (shade))))

(defn get-css []
  (g/css
   [:h1 :h2 {:color (color :dark :brown)
             :text-decoration "underline"}]
   [:body {:font-family ["Roboto" "sans-serif"]
           :font-size "14pt"
           :background-color (color :light :brown)}]
   [:a {:font-size "16pt"
        :font-weight "bold"
        :color "green"
        :text-decoration "none"}]
   [:#nav [:a {:font-size "18pt"
               :font-family ["Roboto" "sans-serif"]}]]
   [:ul {:list-style-position "inside"
         :list-style-type "none"
         :margin "20px"
         :padding "0"
         :background-color (color :medium :brown)}
    [:ul {:margin "0 0 0 20px"} ; order is T R B L
     ]]
   [:#re-frame {:font-size "10pt"}]
   ))
