(ns vexflow-demo.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [vexflow-demo.events]
              [vexflow-demo.subs]
              [vexflow-demo.views :as views]
              [vexflow-demo.style :as style]
              [vexflow-demo.config :as config]
              [Vex :as vexflow]))


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



(defonce VF vexflow/Flow)
(js/console.log VF)

(defn do-vexflow-demo []
  (defonce vf-div (js/document.getElementById "vex"))
  (defonce vf-renderer (VF.Renderer. vf-div VF.Renderer.Backends.SVG))
  (.resize vf-renderer 500 500)
  (let [context (.getContext vf-renderer)
        stave (VF.Stave. 10 40 400)]
    (js/console.log "stave")
    (js/console.log stave)
    (.setBackgroundFillStyle (.setFont context "Arial" 10 "") "#eed")
    (.addClef stave "treble")
    (.addTimeSignature stave "4/4")
    (.setContext stave context)
    (.draw stave)
    (let [notes #js [(VF.StaveNote. #js {:clef "treble" :keys #js ["c/4"] :duration "q"})
                     (VF.StaveNote. #js {:clef "treble" :keys #js ["d/4"] :duration "q"})
                     (VF.StaveNote. #js {:clef "treble" :keys #js ["b/4"] :duration "qr"})
                     (VF.StaveNote. #js {:clef "treble" :keys #js ["c/4" "e/4" "g/4"] :duration "q"})]
          voice (VF.Voice. #js {:num_beats 4 :beat_value 4})
          formatter (VF.Formatter.)
          voices #js [voice]]
      (.addTickables voice notes)
      (.joinVoices formatter voices)
      (.format formatter voices 400)
      (.draw voice context stave)
    )))

(set! js/VF VF)

(try
  (do-vexflow-demo))


(set! (.-onload js/window) do-vexflow-demo)
