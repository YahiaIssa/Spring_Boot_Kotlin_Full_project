package com.example.Spring_boot_basics_kotlin1.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "quotes")
data class QuotesConfig (
    val search: SearchConfig,
    val validation:ValidationConfig
) {
    data class SearchConfig(
            val ignoreCase: Boolean = true,
            val minLength:Int=3,
            val maxLength:Int=500
    )
    data class ValidationConfig(
            val minContentLength:Int=5,
            val maxContentLength:Int=500,
            val requireAuthor:Boolean=true,
            val allowedCategories: List<String> =emptyList()
    )
}
