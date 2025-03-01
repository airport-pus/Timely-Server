package com.timely.domain.info.controller

import com.timely.domain.info.controller.dto.InfoResponse
import com.timely.domain.info.service.InfoService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@Tag(name = "Info API", description = "학교 정보 API")
class InfoController(private val infoService: InfoService) {

    @GetMapping("/info")
    @Operation(summary = "학교 정보 조회", description = "학교 이름을 통해 학교 정보를 조회합니다.")
    suspend fun getInfo(
        @Parameter(description = "학교 이름", required = true, example = "부산소프트웨어마이스터고등학교")
        @RequestParam schoolName: String
    ): Mono<InfoResponse> {
        return infoService.getInfo(schoolName)
    }
}
