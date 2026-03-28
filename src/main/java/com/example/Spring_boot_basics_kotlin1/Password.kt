package com.example.Spring_boot_basics_kotlin1

import jakarta.validation.Constraint
import jakarta.validation.constraints.Pattern
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [])
@Pattern(regexp = "^[a-zA-Z0-9_]*$",
    message = "password must have at least 9 characters")

annotation class Password(
    val message: String = "password must contain at least 9 characters",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Any>> = []
)
