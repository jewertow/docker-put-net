FROM openjdk:8-jre-alpine

ENV KAFKA_CONSUMER_BOOTSTRAP=""
ENV KAFKA_CONSUMER_TOPIC=""
ENV KAFKA_CONSUMER_GROUP="offer-search-service-group"

ENV ES_CLUSTER_NAME=""
ENV ES_HOST=""
ENV ES_PORT=""

EXPOSE 8080

WORKDIR /
COPY app.jar .
ENTRYPOINT java -jar \
    -Dkafka.consumer.bootstrap=${KAFKA_CONSUMER_BOOTSTRAP} \
    -Dkafka.consumer.topic=${KAFKA_CONSUMER_TOPIC} \
    -Dkafka.consumer.group=${KAFKA_CONSUMER_GROUP} \
    -Dspring.data.elasticsearch.cluster-name=${ES_CLUSTER_NAME} \
    -Dspring.data.elasticsearch.cluster-name=${ES_HOST}:${ES_PORT} \
    ./app.jar
