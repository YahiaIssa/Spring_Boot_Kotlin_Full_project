package com.example.Spring_boot_basics_kotlin1

import com.example.Spring_boot_basics_kotlin1.service.QuotesService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping("/qoutes")
class QuoteController(
    private val quotesService:QuotesService,
    private val restTemplate: RestTemplate
) {
     val qoutes=mutableListOf<QuoteDto>()

    @GetMapping
    fun lodeQuotes(
        @RequestParam(value = "Q", required = false) query: String?
    ): List<QuoteDto>{
    return quotesService.getQoutes(query)
    }

    @PostMapping
    fun postQuotes(

        @Valid @RequestBody qoutesdto:QuoteDto
    ): QuoteDto{
    return quotesService.insertQuote(qoutesdto)
    }
    @PutMapping
    fun putQuote(
        @RequestBody qouteDto: QuoteDto
    ): QuoteDto{
        val index = qoutes.indexOfFirst{it.id == qouteDto.id}
        qoutes[index] = qouteDto

        return qouteDto
    }

    @DeleteMapping("/{id}")
    fun deleteQuote(
        @PathVariable ("id") id: Long
    ){
       val qouteToDelete =qoutes.find{ it.id == id}
         if (qouteToDelete != null) {
            qoutes.remove(qouteToDelete)
        }else{
            throw QoutesNotFoundException(id)
        }

    }
}