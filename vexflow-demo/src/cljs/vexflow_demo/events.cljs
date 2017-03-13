(ns vexflow-demo.events
    (:require [re-frame.core :as re-frame]
              [vexflow-demo.db :as db]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))
