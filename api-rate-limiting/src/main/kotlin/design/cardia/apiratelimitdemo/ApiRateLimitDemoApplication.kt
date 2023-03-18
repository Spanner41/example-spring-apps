package design.cardia.apiratelimitdemo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class ApiRateLimitDemoApplication

fun main(args: Array<String>) {
    SpringApplication.run(ApiRateLimitDemoApplication::class.java, *args)
}
