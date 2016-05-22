(set-env!
 :resource-paths #{"src"}
 :dependencies '[
                 [ring/ring-core "1.4.0"]
                 [adzerk/bootlaces "0.1.13"]
                 [org.clojure/clojure "1.8.0"]])

(require '[adzerk.bootlaces :refer :all])

(def +version+ "0.1.0")

(bootlaces! +version+)

(task-options!
 pom {:project 'dgellow/utils
      :version +version+
      :description "Some personal helpers"
      :url "https://github.com/dgellow/clj-utils"
      :scm {:url "https://github.com/dgellow/clj-utils"}
      :license {"EPL" "http://www.eclipse.org/legal/epl-v10.html"}})

(deftask build
  "Build project"
  []
  (comp (pom)
        (jar)))
