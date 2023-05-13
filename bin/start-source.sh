#!/bin/bash

docker exec -it pulsar /pulsar/bin/pulsar-admin source create --name tweety --archive file:///tweetSource/tweet-simulator-1.0-SNAPSHOT-jar-with-dependencies.jar --destination-topic-name public/default/tweets-in

################################################
# Wait 5 seconds for Pulsar to start
################################################
sleep 5


docker exec -it pulsar /pulsar/bin/pulsar-admin sources get --name tweety

