(ns lib.getdata
  "Get a real time price"
  (:require [org.httpkit.client :as http])
  (:require [lib.transformations :refer :all]))

(defn data
  "Get Price, pass in [(asynch t/f)(symbol Stock.symbol)(type e.g. price)]"
  [type symbol async debug]
  (let [url (str "https://api.iextrading.com/1.0/stock/" symbol "/" type)]
    (if async
      ; asynchronous
      (http/get url {:timeout 400}
        (fn [{:keys [status headers body error]}]
        (if error
          (println "Failed, exception: " error)
          (if debug (println "Async Price HTTP GET: " status " | " body)))
      body))
      ; synchronous with promise
      (let [{:keys [status headers body error] :as resp} @(http/get url)]
        (if error
          (println "Failed, exception: " error)
          (if debug (println "Sync Price HTTP GET: " status " | " body)))
      body))))

(defn get-price
  "simply get the price synch"
  [symbol]
  (data "price" symbol false false))

(defn get-stat
  "pass in raw json stats, get key value - key is string value"
  [stats key]
  (-> stats
    (json2map)
    (get key)))

(defn get-stats
  "simply get the json stats synch"
  [symbol]
  (data "stats" symbol false false))

(defn get-company-name
  "get name, json"
  ([symbol] (get-company-name symbol false)) ;default to synchronous
  ([symbol async] (data "stats?filter=companyName" symbol async false)))

(defn get-market-cap
  "get market cap, json"
  ([symbol] (get-market-cap symbol false)) ;default to synchronous
  ([symbol async] (data "stats?filter=marketcap" symbol async false)))

(defn get-beta
  "get beta, json"
  ([symbol] (get-beta symbol false)) ;default to synchronous
  ([symbol async] (data "stats?filter=beta" symbol async false)))

(defn get-52w-h
  "get 52 week high, json"
  ([symbol] (get-52w-h symbol false)) ;default to synchronous
  ([symbol async] (data "stats?filter=week52high" symbol async false)))

(defn get-52w-l
  "get 52 week low, json"
  ([symbol] (get-52w-l symbol false)) ;default to synchronous
  ([symbol async] (data "stats?filter=week52low" symbol async false)))

(defn get-52w-c
  "get 52 week change, json"
  ([symbol] (get-52w-c symbol false)) ;default to synchronous
  ([symbol async] (data "stats?filter=week52change" symbol async false)))

(defn get-dividend-yield
  "get dividend yield, json"
  ([symbol] (get-dividend-yield symbol false)) ;default to synchronous
  ([symbol async] (data "stats?filter=dividendYield" symbol async false)))

(defn get-ebitda
  "get EBITDA, json"
  ([symbol] (get-ebitda symbol false)) ;default to synchronous
  ([symbol async] (data "stats?filter=EBITDA" symbol async false)))

(defn get-revenue
  "get revenue, json"
  ([symbol] (get-revenue symbol false)) ;default to synchronous
  ([symbol async] (data "stats?filter=revenue" symbol async false)))

(defn get-50d-mv-avg
  "get 50 day moving average, json"
  ([symbol] (get-50d-mv-avg symbol false)) ;default to synchronous
  ([symbol async] (data "stats?filter=day50MovingAvg" symbol async false)))

(defn get-institution-percent
  "get percent of institution holders, json"
  ([symbol] (get-institution-percent symbol false)) ;default to synchronous
  ([symbol async] (data "stats?filter=institutionPercent" symbol async false)))

(defn get-12m-trail-eps
  "get 12 month trailing EPS, json"
  ([symbol] (get-12m-trail-eps symbol false)) ;default to synchronous
  ([symbol async] (data "stats?filter=ttmEPS" symbol async false)))

;NEXT
; EBITDA
; revenue
; day50MovingAvg
; institutionPercent
; ttmEPS
;TODO
; symbol
; shortInterest
; shortDate
; dividendRate
; exDividendData
; latestEPS
; latestEPSDate
; sharesOutstanding
; float
; returnOnEquity
; consensusEPS
; numberOfEstimates
; EPSSurpriseDollar
; EPSSurprisePercent
; grossProfit
; cash
; debt
; ttmEPS
; revenuePerShare
; revenuePerEmployee
; peRatioHigh
; peRatioLow
; returnOnAssets
; returnOnCapital
; profitMargin
; priceToSales
; priceToBook
; day200MovingAvg
; institutionPercent
; insiderPercent
; shortRatio
; year5ChangePercent
; year2ChangePercent
; year1ChangePercent
; ytdChangePercent
; month6ChangePercent
; month3ChangePercent
; month1ChangePercent
; day5ChangePercent
; day30ChangePercent