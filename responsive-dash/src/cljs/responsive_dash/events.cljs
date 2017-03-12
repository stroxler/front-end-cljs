(ns responsive-dash.events
    (:require [re-frame.core :as re-frame]
              [responsive-dash.db :as db]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))
