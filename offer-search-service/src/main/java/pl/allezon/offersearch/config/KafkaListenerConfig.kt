package pl.allezon.offersearch.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.Deserializer
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer
import pl.allezon.offersearch.domain.Offer

import java.util.HashMap

@Configuration
@EnableKafka
open class KafkaListenerConfig(
        @Value("\${kafka.consumer.bootstrap}") private val bootstrap: String,
        @Value("\${kafka.consumer.group}") private val group: String,
        @Value("\${kafka.consumer.topic}") private val topic: String
) {

    @Bean
    open fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, Offer> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, Offer>()
        factory.setConcurrency(1)
        factory.consumerFactory = consumerFactory()
        return factory
    }

    @Bean
    open fun consumerFactory(): ConsumerFactory<String, Offer> {
        return DefaultKafkaConsumerFactory<String, Offer>(consumerProps(), stringKeyDeserializer(), offerJsonDeserializer())
    }

    @Bean
    open fun consumerProps(): Map<String, Any> {
        val props = HashMap<String, Any>()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrap
        props[ConsumerConfig.GROUP_ID_CONFIG] = group
        props[ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG] = true
        props[ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG] = "100"
        props[ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG] = "15000"
        return props
    }

    @Bean
    open fun stringKeyDeserializer(): Deserializer<String> {
        return StringDeserializer()
    }

    @Bean
    open fun offerJsonDeserializer(): Deserializer<Offer> {
        return JsonDeserializer(Offer::class.java)
    }
}
