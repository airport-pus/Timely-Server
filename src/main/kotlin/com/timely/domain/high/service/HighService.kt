package com.timely.domain.high.service

import com.timely.common.config.ApiProperties
import com.timely.domain.high.controller.dto.HighTimeRequest
import com.timely.domain.high.controller.dto.HighTimeResponse
import com.timely.domain.high.service.dto.ApiHighTimetableResponse
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class HighService(
    private val apiProperties: ApiProperties,
    private val highWebClient: WebClient
) {

    fun getHighTime(request: HighTimeRequest): Mono<HighTimeResponse> {
        return highWebClient.get()
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
            .bodyToMono(ApiHighTimetableResponse::class.java)
            .map(HighTimeResponse::from)
    }
}