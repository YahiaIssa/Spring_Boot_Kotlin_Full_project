package com.example.Spring_boot_basics_kotlin1

class QoutesNotFoundException(
    private val id: Long
):RuntimeException(
    "A qoute with $id ID")

