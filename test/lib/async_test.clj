(ns lib.async-test
  (:require [clojure.test :refer :all])
  (:require [lib.async :refer :all]))

;; TODO write test that works for this
(deftest async-price-test
  (testing "Test a couple nasdaq prices Async"
    (is
      (let [syms (list 'aapl 'goog)]
        (-> syms
          (async-prices)
          (nil?)
          (not))))))

