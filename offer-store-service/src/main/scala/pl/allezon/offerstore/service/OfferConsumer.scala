package pl.allezon.offerstore.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.stereotype.Service
import pl.allezon.offerstore.repository.OfferRepository
import pl.allezon.offerstore.domain.{Offer, OfferDto}

@Service
class OfferConsumer @Autowired() (
  val offerRepository: OfferRepository
 ) {

  private val log = LoggerFactory.getLogger(classOf[OfferConsumer])

  @KafkaListener(topics = Array ("${kafka.consumer.topic}"))
  def onReceive(
                 offerDto: OfferDto,
                 @Header (KafkaHeaders.OFFSET) offset: Integer,
                 @Header (KafkaHeaders.RECEIVED_PARTITION_ID) partition: Int,
                 @Header (KafkaHeaders.RECEIVED_TOPIC) topic: String
  ): Unit = {
    log.info(s"Received event: topic = $topic, partition = $partition, offset = $offset, offer = $offerDto")
    val offer = Offer(offerDto.id.toString, offerDto.name, offerDto.description)
    log.info(s"Created offer: $offer")
    offerRepository.save(offer)
  }
}

