(ns foo
  (:require [jaki.couch :as couch]))

;; stolen from pinot
;; https://github.com/ibdknox/pinot/blob/master/src/pinot/util/js.cljs
(defn map->js [m]
  (let [out (js-obj)]
    (doseq [[k v] m]
      (aset out (name k) v))
    out))

(defn ^:export insert-couches [model]
  (couch/all-dbs (fn [dbs]
                   (doall
                    (map #(. model (append (map->js {:name %})))
                         dbs)))))
