#!/bin/bash

echo "Building allezon/offer-search-service:build container"

docker build -t allezon/offer-search-service:build -f Dockerfile.build .

docker container create --name extract allezon/offer-search-service:build
docker container cp extract:/tmp/build/libs/offer-search-service.jar ./app.jar
docker container rm -f extract

echo "Building allezon/offer-search-service:$1 container"
docker build --no-cache -t allezon/offer-search-service:$1 .
