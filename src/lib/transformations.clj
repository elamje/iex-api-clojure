(ns lib.transformations
  "Transform data here"
  (:require [clojure.data.json :as json]))

(defn json2map
  "take the json from the api and digest to map"
  [api-response]
  (json/read-str api-response))

(defn symbols2map
  "take the lazy seq from building data and digest to map"
  [data]
  (into (sorted-map) data))

  (defn symbols2urls
    "take in list of symbols, output api urls, optional 2nd param, default price"
    ([symbol-list] (map #(str "https://api.iextrading.com/1.0/stock/" % "/price") symbol-list))
    ([symbol-list type] (map #(str "https://api.iextrading.com/1.0/stock/" % "/" type) symbol-list)))
