(ns lib.async
  (:require [org.httpkit.client :as http]
            [lib.transformations :refer :all]))

(defn async-data
  "query multiple prices async and concat results"
  [symbol-list type]
  (as-> symbol-list $
    (symbols2urls $ type)
    (map http/get $)
    (doall $)
    (doseq [resp $]
      (println (-> @resp :opts :url) ":" (:body @resp))))
  false)


  