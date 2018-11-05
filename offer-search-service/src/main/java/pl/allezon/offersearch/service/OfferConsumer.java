package pl.allezon.offersearch.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;
import pl.allezon.offersearch.domain.Offer;
import pl.allezon.offersearch.repository.OfferRepository;

@Service
public class OfferConsumer {

    private static final Logger log = LoggerFactory.getLogger(OfferConsumer.class);
    private final OfferRepository offerRepository;

    @Autowired
    public OfferConsumer(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @KafkaListener(topics = "${kafka.consumer.topic}")
    public void onReceiving(
            Offer offer,
            @Header(KafkaHeaders.OFFSET) Integer offset,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic
    ) {
        log.info("Received event: topic = {}, partition = {}, offset = {}, offer = {}", topic, partition, offset, offer);
        offerRepository.save(offer);
    }
}
