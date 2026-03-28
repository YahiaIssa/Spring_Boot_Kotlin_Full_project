package com.example.Spring_boot_basics_kotlin1

import com.example.Spring_boot_basics_kotlin1.config.QuotesConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(
	QuotesConfig::class
)
class SpringBootBasicsKotlin1Application

fun main(args: Array<String>) {
	runApplication<SpringBootBasicsKotlin1Application>(*args)
}