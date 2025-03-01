package com.timely.domain.timetable.controller

import com.timely.domain.timetable.controller.dto.TimetableRequest
import com.timely.domain.timetable.controller.dto.TimetableResponse
import com.timely.domain.timetable.service.TimetableService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@Tag(name = "Timetable API", description = "학교 시간표 API")
class TimetableController(private val timetableService: TimetableService) {

    @PostMapping("/timetable")
    @Operation(summary = "시간표 조회", description = "학교 시간표를 조회합니다.")
    suspend fun getTime(
        @Parameter(description = "시간표 조회 요청 데이터", required = true) @RequestBody request: TimetableRequest
    ): Mono<TimetableResponse> {
        return timetableService.getTimetable(request)
    }
}
