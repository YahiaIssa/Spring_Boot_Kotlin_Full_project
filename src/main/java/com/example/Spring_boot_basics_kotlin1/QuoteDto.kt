package com.example.Spring_boot_basics_kotlin1

import org.hibernate.validator.constraints.Length


data class QuoteDto(

    val id: Long? = null,
    @field:Length(
        min = 5,
        max = 500,
        message = "Content must be between 5-500"
    )

    val content: String,
    @field:Password
    val author: String

    )

