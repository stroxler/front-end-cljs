(defproject vexflow-demo "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.229"]
                 [reagent "0.6.0"]
                 [re-frame "0.9.2"]
                 [garden "1.2.3"]]

  :plugins [[lein-cljsbuild "1.1.4"]]

  :min-lein-version "2.5.3"

  :source-paths ["src/clj"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

  :figwheel {:css-dirs ["resources/public/css"]}

  :profiles
  {:dev
   {:dependencies [[binaryage/devtools "0.8.2"]]

    :plugins      [[lein-figwheel "0.5.7"]]
    }}

  :cljsbuild
  {:builds
   [{:id           "dev"
     :source-paths ["src/cljs"]
     :figwheel     {:on-jsload "vexflow-demo.core/mount-root"}
     :compiler     {:main                 vexflow-demo.core
                    :output-to            "resources/public/js/compiled/app.js"
                    :output-dir           "resources/public/js/compiled/out"
                    :asset-path           "js/compiled/out"
                    :source-map-timestamp true
                    :preloads             [devtools.preload]
                    :external-config      {:devtools/config {:features-to-install :all}}
                    :foreign-libs [{:file "src/js/vexflow-dbg.js"
                                    :file-min "src/js/vexflow-min.js"
                                    :provides ["Vex"]
                                    :module-type :commonjs}]
                    }}

    {:id           "min"
     :source-paths ["src/cljs"]
     :compiler     {:main            vexflow-demo.core
                    :output-to       "resources/public/js/compiled/app.js"
                    :optimizations   :advanced
                    :closure-defines {goog.DEBUG false}
                    :pretty-print    false
                    :foreign-libs [{:file "src/js/vexflow-dbg.js"
                                    :file-min "src/js/vexflow-min.js"
                                    :provides ["Vex"]
                                    :module-type :commonjs}]
                    }}


    ]}

  )
