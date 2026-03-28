package com.example.Spring_boot_basics_kotlin1

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.ResponseErrorHandler
import org.springframework.web.client.RestTemplate

@Configuration
open class RestConfig {
    @Bean
   open fun restTemplate(): RestTemplate {
    return RestTemplate().apply {
        errorHandler= ResponseErrorHandler{response ->
            response.body.use {
                it.readBytes().decodeToString().startsWith("Error ")
            }
        }
    }
    }
}