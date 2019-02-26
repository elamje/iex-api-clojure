(ns lib.core
  (:gen-class)
  (:require [lib.structures]
            [lib.getdata :refer :all]
            [lib.transformations :refer :all]
            [lib.core-test :refer :all]
            [lib.getdata-test :refer :all]
            [lib.async-test :refer :all]
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

(defn reload
  "hotswap popular namespaces and dependencies with reload-all"
  []
  (use 'lib.core :reload-all)
  (use 'lib.getdata :reload-all)
  (use 'lib.getdata-test :reload-all)
  (use 'lib.async-test :reload-all)
  (println "just reloaded core, getdata, getdata-test, async-test"))

(defn test-runner
  "Call Tests on each namespace"
  []
  (run-tests 'lib.core-test)
  (run-tests 'lib.getdata-test)
  (run-tests 'lib.async-test))

(defn build-ref-data
  "Build all global vars needed for testing/repling"
  []
  (as-> "resources/NASDAQ.csv" $
    (build-data $)
    (symbols2map $)))

;dsfadsfds

(defn -main 
  "call something"
  [& args]
  (api)
  (build-ref-data)
  (test-runner))

