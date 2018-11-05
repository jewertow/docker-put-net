#!/bin/bash

echo "Building allezon/offer-store-service:build container"

docker build -t allezon/offer-store-service:build -f Dockerfile.build .

docker container create --name extract allezon/offer-store-service:build
docker container cp extract:/tmp/target/ ./target/
docker container rm -f extract

echo "Building allezon/offer-store-service:$1 container"
docker build --no-cache -t allezon/offer-store-service:$1 .
