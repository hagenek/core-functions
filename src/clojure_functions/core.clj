(ns clojure-functions.core)
(use 'clojure.repl)

;;; This is an incorrect implementation, such as might be written by
;;; someone who was used to a Lisp in which an empty list is equal to
;;; nil.
(defn first-element [sequence default]
  (if (empty? sequence)
    default
    (first sequence)))

(defn my-reduce
  "expects a funtion a value and a collection"
  ([f coll] (my-reduce f (f (first coll) (second coll)) coll))
  ([f val coll]
   (loop [acc val remaining-coll coll]
     (if (empty? remaining-coll)
       acc
       (recur  (f acc (first remaining-coll)) (rest remaining-coll))))))

