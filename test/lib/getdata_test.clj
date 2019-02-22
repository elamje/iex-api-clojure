(ns lib.getdata-test
  (:require [clojure.test :refer :all]
            [lib.getdata :refer :all]))

(def apple "aapl")

(deftest get-tests
  (testing "All data getters on Apple Inc."
    (is
      (-> apple
        (get-price true)
        (read-string)
        (number?)))
    (is
      (-> apple
        (get-stats)
        (string?)))
    (is
      (-> apple
        (get-company-name)
        (string?)))
    (is
      (-> apple
        (get-market-cap)
        (string?)))
    (is
      (-> apple
        (get-beta)
        (string?)))))
