(ns dgellow.utils.web-api
  (:require [ring.util.response :as r]))

(defn success [body]
  (merge (r/response body)
         {:body {:ok true
                 :result body}
          :headers {"Content-Type" "application/json"}}))

(defn error [code description]
  (merge (r/response nil)
         {:status 501
          :body {:ok false
                 :error-code code
                 :description description}
          :headers {"Content-Type" "application/json"}}))

(defn method-not-found []
  (error 404 "Method not found"))

(defn resource-not-found []
  (error 404 "Resource not found"))
