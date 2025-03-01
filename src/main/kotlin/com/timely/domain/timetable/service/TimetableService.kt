package com.timely.domain.timetable.service

import com.timely.common.config.ApiProperties
import com.timely.domain.timetable.controller.dto.TimetableRequest
import com.timely.domain.timetable.controller.dto.TimetableResponse
import com.timely.domain.timetable.service.dto.ApiElementaryTimeResponse
import com.timely.domain.timetable.service.dto.ApiMiddleTimetableResponse
import com.timely.domain.timetable.service.dto.ApiHighTimetableResponse
import com.timely.domain.timetable.domain.value.SchoolType
import com.timely.domain.timetable.exception.TimetableInvalidException
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class TimetableService(
    private val apiProperties: ApiProperties,
    private val elementaryWebClient: WebClient,
    private val middleWebClient: WebClient,
    private val highWebClient: WebClient
) {

    fun getTimetable(request: TimetableRequest): Mono<TimetableResponse> {
        val schoolType = SchoolType.from(request.schoolType)
        val webClient = getWebClientBySchoolType(schoolType)

        return webClient.get()
            .uri { builder ->
                builder
                    .queryParam("KEY", apiProperties.serviceKey)
                    .queryParam("Type", "json")
                    .queryParam("ATPT_OFCDC_SC_CODE", request.atptOfcdcScCode)
                    .queryParam("SD_SCHUL_CODE", request.sdSchulCode)
                    .queryParam("GRADE", request.grade)
                    .queryParam("CLASS_NM", request.classNm)
                    .queryParam("TI_FROM_YMD", request.startYmd)
                    .queryParam("TI_TO_YMD", request.endYmd)
                    .build()
            }
            .retrieve()
            .bodyToMono(getResponseTypeBySchoolType(schoolType))
            .map { response -> mapToTimetableResponse(response) }
    }

    private fun getWebClientBySchoolType(schoolType: SchoolType): WebClient {
        return when (schoolType) {
            SchoolType.ELEMENTARY -> elementaryWebClient
            SchoolType.MIDDLE -> middleWebClient
            SchoolType.HIGH -> highWebClient
        }
    }

    private fun getResponseTypeBySchoolType(schoolType: SchoolType): Class<*> {
        return when (schoolType) {
            SchoolType.ELEMENTARY -> ApiElementaryTimeResponse::class.java
            SchoolType.MIDDLE -> ApiMiddleTimetableResponse::class.java
            SchoolType.HIGH -> ApiHighTimetableResponse::class.java
        }
    }

    private fun mapToTimetableResponse(response: Any): TimetableResponse {
        return when (response) {
            is ApiElementaryTimeResponse -> TimetableResponse.from(response)
            is ApiMiddleTimetableResponse -> TimetableResponse.from(response)
            is ApiHighTimetableResponse -> TimetableResponse.from(response)
            else -> throw TimetableInvalidException()
        }
    }
}
