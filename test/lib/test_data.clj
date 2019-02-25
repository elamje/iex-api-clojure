(ns lib.test-data
  (:gen-class)
  (:require [clojure.test :refer :all]
            [clojure.java.io :as io]
            [clojure.data.csv :as csv]))


(defn build-data 
  "Build up test data set of csv format"
  []
  (with-open [in-file (io/reader "resources/NASDAQ.csv")]
    (doall
      (csv/read-csv in-file))))