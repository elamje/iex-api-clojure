(ns lib.async-test
  (:require [clojure.test :refer :all])
  (:require [lib.async :refer :all]))

(deftest async-data-test
  (testing "Get All nasdaq prices Async"
    (is ; price
      (let [syms (list 'aapl 'goog)]
        (-> syms
          (async-data "price")
          (nil?)
          (not))))
    (is ; stats
      (let [syms (list 'aapl 'goog)]
        (-> syms  
          (async-data "stats")
          (nil?)
          (not))))))