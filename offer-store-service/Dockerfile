FROM openjdk:8-jre-alpine

ENV KAFKA_CONSUMER_BOOTSTRAP=""
ENV KAFKA_CONSUMER_TOPIC=""
ENV KAFKA_CONSUMER_GROUP="offer-store-service-group"

ENV MONGODB_HOST=""
ENV MONGODB_PORT=""
ENV MONGODB_USERNAME=""
ENV MONGODB_PASSWORD=""
ENV MONGODB_DATABASE=""

WORKDIR /
COPY app.jar .
ENTRYPOINT java -jar \
    -Dkafka.consumer.bootstrap=${KAFKA_CONSUMER_BOOTSTRAP} \
    -Dkafka.consumer.topic=${KAFKA_CONSUMER_TOPIC} \
    -Dkafka.consumer.group=${KAFKA_CONSUMER_GROUP} \
    -Dspring.data.mongodb.host=${MONGODB_HOST} \
    -Dspring.data.mongodb.port=${MONGODB_PORT} \
    -Dspring.data.mongodb.username=${MONGODB_USERNAME} \
    -Dspring.data.mongodb.password=${MONGODB_PASSWORD} \
    -Dspring.data.mongodb.database=${MONGODB_DATABASE} \
    ./app.jar

