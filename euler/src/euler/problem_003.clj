; Project Euler - Problem 003
; https://projecteuler.net/problem=3

; The prime factors of 13195 are 5, 7, 13 and 29.
;
; What is the largest prime factor of the number 600851475143?

(ns euler.problem-003)

(defn is-prime?
  "Determine if n is a prime number"
  [n]
  (loop [m (dec n)]
    (if (= m 1)
      true
      (if (= 0 (mod n m))
        false
        (recur (dec m))))))

(defn problem-003
  "Find largest prime factor of n"
  [n]
  (loop [m 2]
    (let [factor (/ n m)
          divisible (= 0 (mod n m))]
      (if (= 1 factor)
        factor
        (if (and divisible (and (odd? factor) (is-prime? factor)))
          factor
          (recur (inc m)))))))
