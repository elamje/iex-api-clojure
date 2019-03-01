(ns lib.async-test
  (:require [clojure.test :refer :all])
  (:require [lib.async :refer :all]
            [lib.getdata :refer :all]))

; ref data builder
(def nasdaq (build-ref-data))

(defn nasdaq-subset
  "get subset of nasdaq for testing"
  []
  (as-> nasdaq ndq
    (keys ndq)
    (random-sample 0.03 ndq)))

(deftest async-data-test
  (testing "Get random subset NASDAQ Async info and prices"
    (is ;Info/Stats
      (let [syms (nasdaq-subset)]
        (-> syms
          (async-data "stats")
          (nil?)
          (not))))
    (is ;Price
      (let [syms (nasdaq-subset)]
        (-> syms  
          (async-data "price")
          (nil?)
          (not))))))