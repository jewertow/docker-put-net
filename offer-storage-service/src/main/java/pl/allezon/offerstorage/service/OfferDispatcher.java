package pl.allezon.offerstorage.service;


import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import pl.allezon.offerstorage.domain.Offer;

@Service
public class OfferDispatcher {

    private static final Logger log = LoggerFactory.getLogger(OfferDispatcher.class);
    private final KafkaTemplate<String, Offer> workUnitsKafkaTemplate;

    @Autowired
    public OfferDispatcher(KafkaTemplate<String, Offer> workUnitsKafkaTemplate) {
        this.workUnitsKafkaTemplate = workUnitsKafkaTemplate;
    }

    public void dispatch(Offer offer) {
        try {
            final SendResult<String, Offer> sendResult = workUnitsKafkaTemplate.sendDefault(offer).get();
            final RecordMetadata recordMetadata = sendResult.getRecordMetadata();
            log.info(
                "Event sent: topic = {}, partition = {}, offset = {}, offer = {}",
                recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset(), offer
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
