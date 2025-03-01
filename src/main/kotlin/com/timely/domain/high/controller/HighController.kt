package com.timely.domain.high.controller

import com.timely.domain.high.controller.dto.HighTimeRequest

import com.timely.domain.high.controller.dto.HighTimeResponse
import com.timely.domain.high.service.HighService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class HighController(private val highService: HighService) {

    @GetMapping("/high")
    suspend fun getTime(@RequestBody requset: HighTimeRequest): Mono<HighTimeResponse> {
        return highService.getHighTime(requset)
    }
}
