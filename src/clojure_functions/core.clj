(ns clojure-functions.core)


(defn my-reduce
  "expects a funtion a value and a collection"
  ([f coll]
   (if (empty? coll) (f)
       (my-reduce f (f (first coll) (second coll)) (rest (rest coll)))))
  ([f val coll]
   (loop [acc val remaining-coll coll]
     (if (empty? remaining-coll)
       acc
       (recur  (f acc (first remaining-coll)) (rest remaining-coll))))))

(defn my-count
  "returns the number of items in a collection"
  ([coll] (my-count coll 0))
  ([coll acc]
   (if (empty? coll)
     acc
     (my-count (rest coll) (inc acc)))))


(defn return-one [n] (+ (- n n) 1))

(defn my-count2
  "refactored my-count"
  [coll]
  (reduce + (map return-one coll)))

(defn counting-helper [acc _] (inc acc))

(defn my-count3 [coll]
  (my-reduce counting-helper 0 coll))

(my-count3 [1 3 6 5 7])

(defn my-filter
  "(filter pred coll) Pred must be free of side effects."
  [pred coll]
  (loop [remaining-coll coll new-coll []]
    (if (empty? remaining-coll)
      (lazy-seq new-coll)
      (if (pred (first remaining-coll))
        (recur (rest remaining-coll) (conj new-coll (first remaining-coll)))
        (recur (rest remaining-coll) new-coll)))))
