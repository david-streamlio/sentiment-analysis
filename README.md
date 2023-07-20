# Sentiment Analysis with Pulsar Functions

---
Requirements

## How to Build

TODO: Explain the docker build process
- use of a local repository for docker images
- Controlling the execution phase in the child modules to prevent the parent from building
- How to confirm that the artifact is loaded

```bash
docker run --rm -it --entrypoint bash streamnative/sentiment-analysis-function:1.0.0

ls -l /pulsar

```

## How to Deploy

- Deploy separately 

```bash
kubectl apply -n sentiment -f function-deployment.yaml

kubectl apply -n sentiment -f source-deployment.yaml
```

- Deploy together as a Function Mesh

```bash
kubectl apply -n sentiment -f mesh-deployment.yaml
```

## How to Validate

Check the output to confirm that the tweets are getting analyzed
```bash
kubectl exec -ti -n pulsar brokers-broker-0 -- ./bin/pulsar-client consume -n 0 -s my-sub persistent://public/default/tweet-output-topic
```

## Future Work

- CI/CD pipeline automation
- Mount Volumes to images
- Mount secrets to images
- Init container
- Sidecar container

---
References

- https://functionmesh.io/
- http://dmp.fabric8.io
- TODO: Sentiment analyzer library