package com.timely.domain.schoolInfo.controller

import com.timely.domain.schoolInfo.controller.dto.SchoolInfoResponse
import com.timely.domain.schoolInfo.service.SchoolInfoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class SchoolInfoController(private val schoolInfoService: SchoolInfoService) {

    @GetMapping("/school")
    suspend fun getSchoolInfo(@RequestParam schoolName: String): Mono<SchoolInfoResponse> {
        return schoolInfoService.getSchoolInfo(schoolName)
    }
}
