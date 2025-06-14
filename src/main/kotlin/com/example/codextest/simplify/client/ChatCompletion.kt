package com.example.codextest.simplify.client

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class ChatCompletionResponse(val choices: List<Choice>)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Choice(val message: Message)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Message(val role: String, val content: String)
