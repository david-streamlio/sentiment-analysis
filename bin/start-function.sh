#!/bin/bash

docker exec -it pulsar /pulsar/bin/pulsar-admin functions create \
--jar file:///functionSource/sentiment-analysis-function-1.0.0.nar \
--classname io.streamnative.functions.ml.SentimentAnalysisFunction \
--inputs public/default/tweets-in \
--output public/default/tweets-out \
--log-topic public/default/tweet-log


sleep 5

docker exec -it pulsar /pulsar/bin/pulsar-admin functions get --name SentimentAnalysisFunction

sleep 10

docker exec -it pulsar /pulsar/bin/pulsar-admin functions stats --name SentimentAnalysisFunction