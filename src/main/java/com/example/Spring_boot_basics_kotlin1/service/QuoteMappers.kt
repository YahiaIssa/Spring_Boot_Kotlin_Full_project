package com.example.Spring_boot_basics_kotlin1.service

import com.example.Spring_boot_basics_kotlin1.QuoteDto
import com.example.Spring_boot_basics_kotlin1.QuoteEntity

fun QuoteEntity.toDto(): QuoteDto {
    return QuoteDto(
        id= this.id,
        content= this.content,
        author= this.author,
    )

}
fun QuoteDto.toEntity(): QuoteEntity {
    val entity = QuoteEntity()

    entity.content = this.content
    entity.author = this.author
    return entity
}

