package com.timely.domain.middle.controller

import com.timely.domain.middle.controller.dto.MiddleTimeRequest
import com.timely.domain.middle.controller.dto.MiddleTimeResponse
import com.timely.domain.middle.service.MiddleService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class MiddleController(private val middleService: MiddleService) {

    @GetMapping("/middle")
    suspend fun getTime(@RequestBody requset: MiddleTimeRequest): Mono<MiddleTimeResponse> {
        return middleService.getMiddleTime(requset)
    }
}
