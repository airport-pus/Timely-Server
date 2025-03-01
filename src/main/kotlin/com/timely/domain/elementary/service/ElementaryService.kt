package com.timely.domain.elementary.service

import com.timely.common.config.ApiProperties
import com.timely.domain.elementary.controller.dto.ElementaryTimeRequest
import com.timely.domain.elementary.controller.dto.ElementaryTimeResponse
import com.timely.domain.elementary.service.dto.ApiElementaryTimeResponse
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class ElementaryService(
    private val apiProperties: ApiProperties,
    private val elementaryWebClient: WebClient
) {

    fun getElementaryTime(request: ElementaryTimeRequest): Mono<ElementaryTimeResponse> {
        return elementaryWebClient.get()
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
            .bodyToMono(ApiElementaryTimeResponse::class.java)
            .map(ElementaryTimeResponse::from)
    }
}
