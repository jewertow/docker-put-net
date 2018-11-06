package pl.allezon.offercache.config

import scala.beans.BeanProperty
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "kafka.consumer")
case class KafkaConsumerProperties() {
  @BeanProperty
  var bootstrap: String = _

  @BeanProperty
  var topic: String = _

  @BeanProperty
  var group: String = _
}
