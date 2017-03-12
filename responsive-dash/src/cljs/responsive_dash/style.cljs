(ns responsive-dash.style
  (:require [garden.core :as g]))


(defn update-css [css-str]
  (let [ style-tag-selector "#garden-css"
        style-tag (.querySelector js/document style-tag-selector)]
    (set! (.-innerHTML style-tag) css-str)))


(def solz ; See http://ethanschoonover.com/solarized
  {;; background colors
   :dnavy    "#002b36"
   :lnavy    "#073642"
   :dbeige   "#eee8d5"
   :lbeige   "#fdf6e3"
   ;; offwhite: it's beige, but less beige than actual beige
   :offwhite "#f8f4f0"
   ;; content-colors - vdgrey and vlgrey are my additions
   :vdgrey   "#485e65"
   :ddgrey   "#586e75"
   :mdgrey   "#657b83"
   :mlgrey   "#839496"
   :llgrey   "#93a1a1"
   :vlgrey   "#a8b7b7"
   ;; colors
   :yellow   "#b58900"
   :orange   "#cb4b16"
   :red      "#dc322f"
   :magenta  "#d33682"
   :violet   "#6c71c4"
   :blue     "#268bd2"
   :cyan     "#2aa198"
   :green    "#859900"})

(def fuic ; See https://flatuicolors.com/
  {;; blue-green
   :turquoise "#1abc9c"
   :green-sea "#16a085"
   ;; green
   :emerald "#2ecc71"
   :nephritis "#27ae60"
   ;; blue
   :peter-river "#3498db"
   :belize-hole "#2980b9"
   ;; violet
   :amethyst "#9b59b6"
   :wisteria "#8e44ad"
   ;; dark bluish-grey
   :wet-asphalt "#34495e"
   :midnight-blue "#2c3e50"
   ;; light neutral-grey
   :concrete "#95a5a6"
   :asbestos "#7f8c8d"
   ;; light grey off-white
   :clouds "#ecf0f1"
   :silver "#bdc3c7"
   ;; red
   :alizarin "#e74c3c"
   :pomegranate "#c0392b"
   ;; orange / red-orange
   :carrot "#e67e22"
   :pumpkin "#d35400"
   ;; yellow / yellow-orange
   :sun-flower "#f1c40f"
   :orange "#f39c12"})

(def muic
  ;; See http://materialuicolors.co
  {;; from pink to green
   :pink "#E91E63"
   :purple "#9C27B0"
   :deep-purple "#673AB7"
   :indigo "#3F51B5"
   :blue "#2196F3"
   :light-blue "#03A9F4"
   :cyan "#00BCD4"
   :teal "#009688"
   :green "#4CAF50"
   ;; and also brown
   :brown "#795548"})

(def style-reset
  "See http://meyerweb.com/eric/tools/css/reset/
  Courtesey of http://learn.shayhowe.com/html-css/building-your-first-web-page/"
  [[:html :body :div :span :applet :object :iframe
    :h1 :h2 :h3 :h4 :h5 :h6 :p :blockquote :pre
    :a :abbr :acronym :address :big :cite :code
    :del :dfn :em :img :ins :kbd :q :s :samp
    :small :strike :strong :sub :sup :tt :var
    :b :u :i :center :dl :dt :dd :ol :ul :li
    :fieldset :form :label :legend
    :table :caption :tbody :tfoot :thead :tr :th :td
    :article :aside :canvas :details :embed
    :figure :figcaption :footer :header :hgroup
    :menu :nav :output :ruby :section :summary
    :time :mark :audio :video
    {:margin 0 :padding 0 :border 0 :font-size "100%"
     :font "inherit" :vertical-align "baseline"}]
   [:article :aside :details :figcaption :figure
    :footer :header :hgroup :menu :nav :section
    {:display "block"}]
   [:blockquote:before :blockquote:after :q:before :q:after
    {:content ""}]
   [:table
    {:border-collapse "collapse"
     :border-spacing 0}]
   [:body {:line-height 1}]
   [:ol :ul {:list-style "none"}]
   [:blockquote :q {:quotes "none"}]])

(def basic-style
  [[:em {:font-weight "bold"}]
   ])

(def admin-style
  [[:body {:font-family ["Roboto" "sans-serif"]}]
   ;; this is pretty much pure styling
   [:.header {:background-color (solz :dnavy)
              :font-size "3em"
              :font-style "italic"
              :color (solz :vlgrey)
              :padding "0.5em 0 0.5em 1em"
              :border "solid"
              :border-width "0 0 0.025em 0"
              :border-color "black"}]
   [:.main {:display "flex"
            :flex-direction "row"}]
   [:nav {:background-color (solz :dnavy)
          :color (solz :llgrey)
          :font-size "1.5em"
          :width "7.5em"
          :height (str (* 2 js/screen.height) "px")}
    [:li {:width "6.5em" ; note this is (- 7.5 (* 2 .5))
          :padding "0.5em"
          :border "solid"
          :border-width "0 0 0.2em 0"
          :border-color (solz :lnavy)
          :transition "0.25s"}]
    [:li:hover {:background-color (solz :lnavy)
                :padding-left "0.6em"}]
    [:li.selected {:background-color (solz :lnavy)}]]
   [:.news-container {:background-color (solz :offwhite)
                      :width "100%"
                      :padding-top "1em"}
    [:section.news {:max-width "55em"
                    :min-width "35em"}
     [:article.news-item {:margin "0 auto"
                          :margin-top "1em"
                          :margin-bottom "1em"
                          :width "80%"
                          :max-width "40em"
                          :background-color (solz :lbeige)
                          :border-style "solid"
                          :border-width "1px"
                          :border-color (solz :lnavy)}
      [:.title {:background-color (solz :dnavy)
                :color (solz :vlgrey)
                :font-style "italic"
                :font-size "1.5em"
                :padding (str (/ 0.5 1.5) "em")
                :font-weight "bold"
                :border-bottom-style "solid"
                :border-bottom-width "1px"
                :border-bottom-color "#383838"}]
      [:.content {:padding "0.5em"
                  :color (solz :vdgrey)}]]]]
   ])

(defn get-css []
  (apply g/css
         (concat
          style-reset
          basic-style
          admin-style
          )))
