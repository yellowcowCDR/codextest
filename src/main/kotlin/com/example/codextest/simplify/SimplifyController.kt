package com.example.codextest.simplify

import com.example.codextest.simplify.dto.SimplifyRequest
import com.example.codextest.simplify.dto.SimplifyResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class SimplifyController(private val service: SimplifyService) {

    @PostMapping("/simplify")
    fun simplify(@RequestBody request: SimplifyRequest): ResponseEntity<SimplifyResponse> {
        val entity = service.simplify(request.text)
        return ResponseEntity.ok(SimplifyResponse(entity.id!!, entity.original, entity.simplified))
    }
}
