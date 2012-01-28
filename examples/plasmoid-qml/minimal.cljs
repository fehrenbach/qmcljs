(ns minimal)

(defn ^:export hello []
  (apply str (interpose " " ["Hello" "world" "from" "ClojureScript!"])))
