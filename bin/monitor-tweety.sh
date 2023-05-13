#!/bin/bash

docker exec -it pulsar /pulsar/bin/pulsar-client consume -n 0 -s tweet-watcher public/default/tweets-in
