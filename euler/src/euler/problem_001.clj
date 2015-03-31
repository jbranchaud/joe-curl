; Project Euler - Problem 001
; https://projecteuler.net/problem=1

; If we list all the natural numbers below 10 that are multiples of 3 or 5,
; we get 3, 5, 6 and 9. The sum of these multiples is 23.
;
; Find the sum of all the multiples of 3 or 5 below 1000.

(ns euler.problem-001)

(defn multiple-of?
  "Is x a multiple of y?"
  [x y]
  (= 0 (mod x y)))

(defn multiple-checker
  "Create a multiple checker"
  [x]
  #(= 0 (mod % x)))

(def multiple-of-3?
  (multiple-checker 3))

(def multiple-of-5?
  (multiple-checker 5))

(defn problem-001
  "Sum multiples of 3 and 5"
  [input]
  (reduce +
    (loop [candidates []
           curr input]
      (if (< curr 3)
        candidates
        (if (or (multiple-of-3? curr) (multiple-of-5? curr))
          (recur (conj candidates curr) (dec curr))
          (recur candidates (dec curr)))))))
