## SearchBox.io Sample Clojure Application.

This example illustrates basic search features of SearchBox.io ([ElasticSearch](http://www.elasticsearch.org) as service).

Sample application is using [Elastisch](http://clojureelasticsearch.info/) Clojure ElasticSearch client to integrate with SearchBox.io.

To create initial index and sample data click Create Sample Index&Data! (2 sample documents will be created.)

Type '*' or 'tweety' or 'tom' to searchbox at top of right corner and hit enter for sample search results.


## Local Setup

To run example in your local environment with a local ElasticSearch instance, change connection string with local url string inside
controllers/search.clj and controllers/indexer.clj to

```
    (esr/connect! http://localhost:9200)
```

## Heroku Deployment

This sample can be deployed to Heroku with no change.

* Install SearchBox ElasticSearch Addon

Deploy sample application and experience real time search.
