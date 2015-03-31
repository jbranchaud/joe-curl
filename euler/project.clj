(defproject euler "0.1.0-SNAPSHOT"
  :description "Solutions to Project Euler problems in Clojure"
  :url "http://example.com"
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :main ^:skip-aot euler.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
