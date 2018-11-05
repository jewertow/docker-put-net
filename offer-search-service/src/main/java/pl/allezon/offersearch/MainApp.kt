package pl.allezon.offersearch

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class MainApp {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(MainApp::class.java, *args)
        }
    }

}
