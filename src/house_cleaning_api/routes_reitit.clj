(ns house-cleaning-api.routes-reitit)

; example route
(def routes
  ["/hello"
   {:get {:handler
          (fn [req]  {:status 200
                      :body "Hello world!"})}}])
