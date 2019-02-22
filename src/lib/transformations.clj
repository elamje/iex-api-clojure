(ns lib.transformations
  "Transform data here"
  (:require [clojure.data.json :as json]))

(defn json2map
  [body]
  (json/read-str body))

