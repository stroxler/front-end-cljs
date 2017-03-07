(ns cc-vids.style
  (:require [garden.core :as g]))

(def img-src
  {:river
   "http://yourshot.nationalgeographic.com/u/ss/fQYSUbVfts-T7pS2VP2wnKyN8wxywmXtY0-FwsgxpzQjRoslAeJLsaiATcf-abezMMtSG1MtOzEtNDyCgLEr/"
   })

(defn update-css [css-str]
  (let [ style-tag-selector "#garden-css"
        style-tag (.querySelector js/document style-tag-selector)]
    (prn style-tag)
    (set! (.-innerHTML style-tag) css-str)))

(defn color [shade hue]
  (let [colors
        {:brown {:light "#f9f2ec"
                 :medium "#edd7c5"
                 :medium-dark "#ad7338"
                 :dark "#734b26"
                 :very-dark "#4d3319"
                 }}]
    (-> colors (hue) (shade))))

(defn get-css []
  (g/css
   [:body {:font-family ["Roboto" "sans-serif"]
           :font-size "14pt"
           :margin "0px"
           :padding "0px"
           :background-color (color :light :brown)}]
   [:#header {:background-image (str "url(" (img-src :river) ")")
              :background-position ["center" "center"]
              :background-size "cover"
              :margin "0px"
              :padding "0px"
              :height "400px"}]
   [:#nav
    {:background-color (color :medium :brown)
     :margin "0 auto"
     :padding "20px"
     :width "100%"
     ;; the three lines below are what make the nav an evenly-spaced
     ;; set of horizontal entries
     :display "flex"
     :flex-direction "row"
     :justify-content "space-around"}
    [:a {:font-size "18pt"
         :width "150px"
         :font-family ["Roboto" "sans-serif"]
         :padding "5px 20px 5px 20px"
         :border "1px solid green"
         :text-align "center"}]]
   [:#main :#re-frame
    {:margin "0px"
     :padding "5px"
     :border-top "2px solid green"}]
   [:h1 :h2 {:color (color :dark :brown)}]
   [:h1 {:font-family ["Gloria Hallelujah" "cursive"]
         :font-size "80px"
         :position "relative" ; this is needed for the :top tag to do anything
         :top "40%" ; this is what shifts it down
         :text-align "center" ; horizontal only
         :margin "0 auto"
         :color (color :very-dark :brown)
         :background-color "rgba(230, 204, 178, 0.40)"}]
   [:h2 {:text-decoration "underline"}]
   [:a {:font-size "16pt"
        :font-weight "bold"
        :color "green"
        :text-decoration "none"}]
   [:ul {:list-style-position "inside"
         :list-style-type "none"
         :margin "20px"
         :padding "0"}
    [:ul {:margin "0 0 0 20px"} ; order is T R B L
     ]]
   [:#re-frame {:font-size "10pt"}]
   ))
