(ns lib.async-test
  (:require [clojure.test :refer :all])
  (:require [lib.async :refer :all]))

(deftest async-data-test
  (testing "Get random subset NASDAQ Async info and prices"
    (is ;Info/Stats
      (let [syms (list 'aapl 'goog)]
        (-> syms
          (async-data "stats")
          (nil?)
          (not))))
    (is ;Price
      (let [syms (list 'aapl 'goog)]
        (-> syms  
          (async-data "price")
          (nil?)
          (not))))))