package com.timely.domain.info.controller

import com.timely.domain.info.controller.dto.InfoResponse
import com.timely.domain.info.service.InfoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class InfoController(private val infoService: InfoService) {

    @GetMapping("/info")
    suspend fun getInfo(@RequestParam schoolName: String): Mono<InfoResponse> {
        return infoService.getInfo(schoolName)
    }
}
