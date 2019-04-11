(ns lib.structures
  "All Data Structures")

(defrecord Price [symbol price])

(defrecord Stock [company symbol price])

; this file is not in use, but it serves as a good reminder of my initial misunderstanding of how to use FP, instead of OOP. I wrestled for a couple of hours trying to understand how to make classes in Clojure, initially. Now I understand that they are largely unnecessary
