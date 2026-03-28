package com.example.Spring_boot_basics_kotlin1.repository

import com.example.Spring_boot_basics_kotlin1.QuoteEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface QuotesRepository: JpaRepository<QuoteEntity,Long> {
fun findByContentContainsIgnoreCase(qurey: String):List<QuoteEntity>
@Query(""" 
    SELECT q
    FROM QuotesEntity q
    WHERE q.content LIKE '%' || :query || '%'
        """)
fun searchQuotes(query: String): List<QuoteEntity>

}