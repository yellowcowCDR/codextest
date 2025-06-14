package com.example.codextest.simplify

import jakarta.persistence.*
import java.time.Instant

@Entity
class SimplifiedText(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val original: String,
    val simplified: String,
    val createdAt: Instant = Instant.now()
)
