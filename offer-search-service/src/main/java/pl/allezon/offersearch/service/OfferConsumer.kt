package pl.allezon.offersearch.service

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.stereotype.Service
import pl.allezon.offersearch.domain.Offer
import pl.allezon.offersearch.repository.OfferRepository

@Service
class OfferConsumer @Autowired
constructor(private val offerRepository: OfferRepository) {

    companion object {
        private val log = LoggerFactory.getLogger(OfferConsumer::class.java)
    }

    @KafkaListener(topics = ["\${kafka.consumer.topic}"])
    fun onReceiving(
        offer: Offer,
        @Header(KafkaHeaders.OFFSET) offset: Int?,
        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) partition: Int,
        @Header(KafkaHeaders.RECEIVED_TOPIC) topic: String
    ) {
        log.info("Received event: topic = {}, partition = {}, offset = {}, offer = {}", topic, partition, offset, offer)
        offerRepository.save(offer)
    }
}
