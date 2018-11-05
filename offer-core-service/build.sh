#!/bin/bash

echo "Building allezon/offer-core-service:build container"

docker build -t allezon/offer-core-service:build -f Dockerfile.build .

docker container create --name extract allezon/offer-core-service:build
docker container cp extract:/tmp/target/offercore-0.1-SNAPSHOT.jar ./app.jar
docker container rm -f extract

echo "Building allezon/offer-core-service:$1 container"
docker build --no-cache -t allezon/offer-core-service:$1 .
