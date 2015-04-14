(ns algorithms.core
  (:gen-class))

(defn -main
  ""
  [& args]
  (println "Hello, Algorithms!"))

; before I knew about the assoc function
(defn swap-old
  "Swap items at position i and j"
  [items i j]
  (let [x (min i j)
        y (max i j)
        a (get items y)
        b (get items x)]
    (loop [swapped-list []
           idx 0
           [itm & remaining] items]
      (if (nil? itm)
        swapped-list
        (if (= idx x)
          (recur (conj swapped-list a) (inc idx) remaining)
          (if (= idx y)
            (recur (conj swapped-list b) (inc idx) remaining)
            (recur (conj swapped-list (get items idx)) (inc idx) remaining)))))))

; bound-checking assoc-based swap function
(defn swap
  [items i j]
  (let [size (count items)]
    (if (or (>= i size) (< i 0) (>= j size) (< j 0))
      items
      (assoc items i (items j) j (items i)))))

(defn clone-vector
  "Clone the given vector"
  [v]
  (map identity v))

;
; Insertion Sort
; http://en.wikipedia.org/wiki/Insertion_sort
;
(defn is-inner-loop
  "insertion sort inner loop"
  [items j]
  (if (and (> j 0) (> (get items (dec j)) (get items j)))
    (recur (swap items j (dec j)) (dec j))
    items))

(defn is-outer-loop
  "insertion sort outer loop"
  [items]
  (let [size (count items)]
    (loop [curr-sort items
           i 1]
      (if (< i (dec size))
        (recur (is-inner-loop curr-sort i) (inc i))
        (is-inner-loop curr-sort i)))))

(defn insertion-sort
  "Sort a vector of comparable items using insertion sort"
  [items]
  (if (>= (count items) 2)
    (is-outer-loop items)
    items))

;
; Selection Sort
; http://en.wikipedia.org/wiki/Selection_sort
;
(defn ss-inner-loop
  "selection sort inner loop"
  [items j]
  (loop [i (inc j)
         i-min j]
    (if (>= i (count items))
      i-min
      (if (< (get items i) (get items i-min))
        (recur (inc i) i)
        (recur (inc i) i-min)))))

(defn ss-outer-loop
  "selection sort outer loop"
  [items]
  (let [size (count items)]
    (loop [curr-sort items
           j 0]
      (if (>= j (dec size))
        curr-sort
        (let [i-min (ss-inner-loop curr-sort j)]
          (if (not (= i-min j))
            (recur (swap curr-sort i-min j) (inc j))
            (recur curr-sort (inc j))))))))

(defn selection-sort
  "Sort a vector of comparable items using selection sort"
  [items]
  (ss-outer-loop items))
