(ns lib.getdata-test
  (:require [clojure.test :refer :all]
            [lib.getdata :refer :all]
            [lib.test-data :refer :all]))

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


(deftest test-data
  (testing "Testing data builder"
    (is
      (-> (build-data "resources/NASDAQ.csv")
        (empty?)))))

(deftest async-nasdaq-prices
  (testing "Testing all Nasdaq symbol prices async"
    ))
