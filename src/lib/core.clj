(ns lib.core
  (:gen-class)
  (:require [lib.structures]
            [lib.getdata :refer :all]
            [lib.transformations :refer :all]
            [lib.core-test :refer :all]
            [lib.getdata-test :refer :all]
            [clojure.test :refer :all])
  (:import  [lib.structures Stock Price]))


(defn api
  "Call Api here"
  []
  (def price (Price. "aapl" (get-price "aapl")))
  (def aapl (Stock. "apple" "AAPL" (get-price "aapl")))
  (def stats (get-stats "aapl"))
  (println aapl)
  (get-stat stats "marketcap"))

(defn test-runner
  "Call Tests on each namespace"
  []
  (run-tests 'lib.core-test)
  (run-tests 'lib.getdata-test))

(defn -main 
  "call something"
  [& args]
  (api)
  (test-runner))

