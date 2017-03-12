(ns responsive-dash.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [responsive-dash.events]
              [responsive-dash.subs]
              [responsive-dash.views :as views]
              [responsive-dash.style :as style]
              [responsive-dash.config :as config]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn add-styles []
  (style/update-css (style/get-css)))

(defn ^:export init []
  (re-frame/dispatch-sync [:initialize-db])
  (dev-setup)
  (add-styles)
  (mount-root))

(try
  (add-styles))
