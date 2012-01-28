(ns foo
  (:require [jaki.couch :as couch]))

;; use absolute URL because we are not served by a couchdb
(reset! jaki.couch/*url-prefix* "http://127.0.0.1:5984")

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
