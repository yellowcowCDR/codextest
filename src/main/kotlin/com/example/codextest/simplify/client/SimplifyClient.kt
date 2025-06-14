package com.example.codextest.simplify.client

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class SimplifyClient(
    builder: WebClient.Builder,
    @Value("\${openai.api.key}")
    private val apiKey: String
) {
    private val webClient: WebClient = builder.baseUrl("https://api.openai.com").build()

    fun simplify(text: String): String {
        val request = mapOf(
            "model" to "gpt-3.5-turbo",
            "messages" to listOf(mapOf("role" to "user", "content" to "Simplify the following text: $text"))
        )
        val response = webClient.post()
            .uri("/v1/chat/completions")
            .contentType(MediaType.APPLICATION_JSON)
            .header("Authorization", "Bearer $apiKey")
            .bodyValue(request)
            .retrieve()
            .bodyToMono(ChatCompletionResponse::class.java)
            .block()
            ?: throw IllegalStateException("No response from LLM")
        return response.choices.firstOrNull()?.message?.content?.trim() ?: text
    }
}
