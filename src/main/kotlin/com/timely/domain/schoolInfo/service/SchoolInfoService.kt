package com.timely.domain.schoolInfo.service

import com.timely.common.config.ApiProperties
import com.timely.domain.schoolInfo.controller.dto.SchoolInfoResponse
import com.timely.domain.schoolInfo.service.dto.ApiSchoolInfoResponse
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class SchoolInfoService(
    private val apiProperties: ApiProperties,
    private val infoWebClient: WebClient
) {

    fun getSchoolInfo(schoolName: String): Mono<SchoolInfoResponse> {
        return infoWebClient.get()
            .uri { builder ->
                builder
                    .queryParam("KEY", apiProperties.serviceKey)
                    .queryParam("Type", "json")
                    .queryParam("SCHUL_NM", schoolName)
                    .build()
            }
            .retrieve()
            .bodyToMono(ApiSchoolInfoResponse::class.java)
            .mapNotNull(SchoolInfoResponse::from)
    }
}
