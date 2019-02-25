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
  (def data_reform (into {} data)))

