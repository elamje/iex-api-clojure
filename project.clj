(defproject io.johnelam/lib "0.1.0"
  :description "IEX Trading Information API 1.0 | real time stock information | direct from exchange"
  :url "https://iextrading.com/developer/"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [ [org.clojure/clojure "1.10.0"]
                  [http-kit "2.3.0"]]
  :resource-paths ["maven_repo/data.json-0.2.6.jar" "maven_repo/data.csv-0.1.2.jar"]
  :main lib.core
  :repl-options {:init-ns lib.core})
