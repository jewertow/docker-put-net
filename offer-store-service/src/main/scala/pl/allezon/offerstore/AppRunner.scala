package pl.allezon.offerstore

import com.fasterxml.jackson.databind.Module
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@EnableMongoRepositories
@SpringBootApplication
class AppRunner {
  @Bean def jacksonScalaModule(): Module = DefaultScalaModule
}

object AppRunner extends App {
  SpringApplication.run(classOf[AppRunner], args :_ *)
}