(ns clojure-functions.core-test
  (:require [midje.sweet :refer :all]
            [clojure-functions.core :refer :all]))

(println "When all these tests are done, do three ave marias for Bob Martin")

(facts "about 'my impl. of reduce"
       (fact "result 1 for add function, with val of 1 and empty coll"
             (my-reduce + 1 []) => 1)
       (fact "result 2 for add function with val 1 and coll with 1 in it"
             (my-reduce + 1 [1]) => 2)
       (fact "result 6 for add function, val of 0 and a collection of 1 2 3 in it"
             (my-reduce + 0 [1 2 3]) => 6)
       (fact "return result of calling function on an empty collection"
             (my-reduce (fn [] "yes") []) => "yes")
       (fact "uses intial value of function applied to first argu, and second argument
              if no start val is supplied"
             (my-reduce + [1 2 3]) => 6))

(facts "about my own count function"
       (fact "result 0 for an empty list"
             (my-count3 '()) => 0)
       (fact "result 0 for nil"
             (my-count3 nil) => 0) 4
       (fact "result 1 for a list of one item"
             (my-count3 '(1)) => 1)
       (fact "result 2 for a list of two items"
             (my-count3 '(1 2)) => 2)
       (fact "result 10 for a list of 10 items"
             (my-count3 [1 2 3 4 5 6 7 8 9 10]) => 10)
       (fact "work with maps, result 2 with 2 key value pairs"
             (my-count3 {:key1 "one" :key2 "two"}) => 2))

(facts "about my own implementation of filter"
       (fact "Results in empty lazy seq. when filtering for zero in an empty vector"
             (class (my-filter zero? [])) => clojure.lang.LazySeq
             (my-count (my-filter zero? [])) => 0))
(fact "results in an lazy sequence with one element with filtering for even in a list when one even number"
      (my-filter even? [1 5 3 2]) => (lazy-seq [2]))

(facts "about `first-element`"
       (fact "it normally returns the first element"
             (first-element [1 2 3] :default) => 1
             (first-element '(1 2 3) :default) => 1)

  ;; I'm a little unsure how Clojure types map onto the Lisp I'm used to.
       (fact "default value is returned for empty sequences"
             (first-element [] :default) => :default
             (first-element '() :default) => :default
             (first-element nil :default) => :default
             (first-element (filter even? [1 3 5]) :default) => :default))
