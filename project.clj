(defproject clojure-functions "0.0.1-SNAPSHOT"
  :description "Project to build the core functions"
  :dependencies [[org.clojure/clojure "1.10.2"]]
  :profiles {:dev {:dependencies [[midje "1.9.9"]]}
             ;; You can add dependencies that apply to `lein midje` below.
             ;; An example would be changing the logging destination for test runs.
             :midje {}})
             ;; Note that Midje itself is in the `dev` profile to support
             ;; running autotest in the repl.


