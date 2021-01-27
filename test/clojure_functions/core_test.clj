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
             (my-reduce + 0 [1 2 3]) => 6))

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
