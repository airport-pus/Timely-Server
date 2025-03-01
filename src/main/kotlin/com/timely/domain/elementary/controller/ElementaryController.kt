package com.timely.domain.elementary.controller

import com.timely.domain.elementary.controller.dto.ElementaryTimeRequest
import com.timely.domain.elementary.controller.dto.ElementaryTimeResponse
import com.timely.domain.elementary.service.ElementaryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class ElementaryController(private val elementaryService: ElementaryService) {

    @GetMapping("/elementary")
    suspend fun getTime(@RequestBody requset: ElementaryTimeRequest): Mono<ElementaryTimeResponse> {
        return elementaryService.getElementaryTime(requset)
    }
}