package pl.allezon.offerstore.config

import java.util
import java.util.{HashMap, Map}

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.{ConsumerFactory, DefaultKafkaConsumerFactory}
import org.springframework.kafka.support.serializer.JsonDeserializer
import pl.allezon.offerstore.domain.{Offer, OfferDto}

@Configuration
@EnableKafka
class KafkaListenerConfig @Autowired()(
  kafkaConsumerProperties: KafkaConsumerProperties
) {

  @Bean def kafkaListenerContainerFactory: ConcurrentKafkaListenerContainerFactory[String, OfferDto] = {
    val factory = new ConcurrentKafkaListenerContainerFactory[String, OfferDto]
    factory.setConcurrency(1)
    factory.setConsumerFactory(consumerFactory)
    factory
  }

  @Bean def consumerFactory = new DefaultKafkaConsumerFactory(consumerProps, stringKeyDeserializer, offerJsonDeserializer)

  @Bean def consumerProps: util.Map[String, AnyRef] = {
    val props = new util.HashMap[String, AnyRef]
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConsumerProperties.bootstrap)
    props.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaConsumerProperties.group)
    props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true.asInstanceOf[AnyRef])
    props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100")
    props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000")
    props
  }

  @Bean def stringKeyDeserializer = new StringDeserializer

  @Bean def offerJsonDeserializer = new JsonDeserializer(classOf[OfferDto])
}
