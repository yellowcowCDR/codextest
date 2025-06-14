package com.example.codextest.simplify.client

import dev.langchain4j.model.openai.OpenAiChatModel
import dev.langchain4j.service.AiServices
import dev.langchain4j.service.UserMessage
import dev.langchain4j.service.V
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

interface SimplifyAiService {
    @UserMessage("Simplify the following text: {{text}}")
    fun simplify(@V("text") text: String): String
}

@Component
class SimplifyClient(
    @Value("\${spring.ai.openai.api-key}")
    private val apiKey: String
) {
    private val service: SimplifyAiService = AiServices.builder(SimplifyAiService::class.java)
        .chatModel(OpenAiChatModel.builder().apiKey(apiKey).build())
        .build()

    fun simplify(text: String): String {
        return service.simplify(text).trim()
    }
}
