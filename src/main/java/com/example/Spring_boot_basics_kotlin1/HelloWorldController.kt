package com.example.Spring_boot_basics_kotlin1

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {
    @GetMapping
    fun helloworld() ="Hello World"

}