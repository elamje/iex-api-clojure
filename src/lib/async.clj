(ns lib.async
  (:require [org.httpkit.client :as http]))
  
(defn symbols2urls
  "take in list of symbols, output api urls"
  [symbol-list]
  (map #(str "https://api.iextrading.com/1.0/stock/" % "/price") symbol-list))

(defn async-prices
  "query multiple prices async and concat results"
  [symbol-list]
  (as-> symbol-list $
    (symbols2urls $)
    (map http/get $)
    (doall $)
    (doseq [resp $])
    (println (-> @resp :opts :url) "price: " (:body @resp))))

    ; (let [futures (doall (map http/get $))]
    ;     (doseq [resp futures]
    ;       (println (-> @resp :opts :url) "status: " (:body @resp))))))

  