package com.timely.domain.middle.service

import com.timely.common.config.ApiProperties
import com.timely.domain.middle.controller.dto.MiddleTimeRequest
import com.timely.domain.middle.controller.dto.MiddleTimeResponse
import com.timely.domain.middle.service.dto.ApiMiddleTimetableResponse
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class MiddleService(
    private val apiProperties: ApiProperties,
    private val middleWebClient: WebClient
) {

    fun getMiddleTime(request: MiddleTimeRequest): Mono<MiddleTimeResponse> {
        return middleWebClient.get()
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
            .bodyToMono(ApiMiddleTimetableResponse::class.java)
            .map(MiddleTimeResponse::from)
    }
}