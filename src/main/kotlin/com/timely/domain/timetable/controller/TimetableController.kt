package com.timely.domain.timetable.controller

import com.timely.domain.timetable.controller.dto.TimetableRequest
import com.timely.domain.timetable.controller.dto.TimetableResponse
import com.timely.domain.timetable.service.TimetableService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class TimetableController(private val timetableService: TimetableService) {

    @PostMapping("/timetable")
    suspend fun getTime(@RequestBody requset: TimetableRequest): Mono<TimetableResponse> {
        return timetableService.getTimetable(requset)
    }
}
