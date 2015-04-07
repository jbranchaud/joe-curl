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
