package com.example.codextest.simplify

import com.example.codextest.simplify.client.SimplifyClient
import org.springframework.stereotype.Service

@Service
class SimplifyService(
    private val repository: SimplifiedTextRepository,
    private val client: SimplifyClient
) {
    fun simplify(text: String): SimplifiedText {
        val simplified = client.simplify(text)
        val entity = SimplifiedText(original = text, simplified = simplified)
        return repository.save(entity)
    }
}
