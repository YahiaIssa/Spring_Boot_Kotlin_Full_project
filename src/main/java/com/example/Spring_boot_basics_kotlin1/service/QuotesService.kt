package com.example.Spring_boot_basics_kotlin1.service

import com.example.Spring_boot_basics_kotlin1.QuoteDto
import com.example.Spring_boot_basics_kotlin1.config.QuotesConfig
import com.example.Spring_boot_basics_kotlin1.repository.QuotesRepository
import jakarta.persistence.Query
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service
@Profile("dev","prod")
class QuotesService(
    val quotesRepository: QuotesRepository,
    @param:Value($$"\${MY_CUSTOM_ENV_VARIABLE}")
    private val version: String,
    private val qoutesConfig: QuotesConfig
) {
    init {
        println(version)

    }
    fun getQoutes(query: String?): List<QuoteDto> {
        return if (query!=null){
    quotesRepository
        .searchQuotes(query)
        .map{it.toDto()}

        }else{
            quotesRepository
                .findAll()
                .map { it.toDto() }
        }
        return quotesRepository
            .findAll()
            .map { it.toDto()}


    }

    fun insertQuote(quote: QuoteDto) :QuoteDto{
        return quotesRepository.
        save(quote.toEntity()
            .apply {
                this.id=0
            })
            .toDto()
    }
    fun updateQuote(quote: QuoteDto):QuoteDto{
        return quotesRepository.
        save(quote.toEntity())
            .toDto()
    }
    fun deleteAllQuotes(quoteId: Long){
       quotesRepository.deleteById(quoteId)
        }
}