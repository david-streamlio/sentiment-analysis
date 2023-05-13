#!/bin/bash

docker exec -it pulsar /pulsar/bin/pulsar-admin source create --name tweety \
--archive file:///tweetSource/tweet-simulator-1.0.0.nar \
--destination-topic-name public/default/tweets-in

################################################
# Wait 5 seconds for Pulsar to start
################################################
sleep 5

docker exec -it pulsar /pulsar/bin/pulsar-admin sources get --name tweety

sleep 10
docker exec -it pulsar /pulsar/bin/pulsar-admin sources status --name tweety

