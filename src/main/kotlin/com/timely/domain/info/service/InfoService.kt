package com.timely.domain.info.service

import com.timely.common.config.ApiProperties
import com.timely.domain.info.controller.dto.InfoResponse
import com.timely.domain.info.service.dto.ApiInfoResponse
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class InfoService(
    private val apiProperties: ApiProperties,
    private val infoWebClient: WebClient
) {

    fun getInfo(schoolName: String): Mono<InfoResponse> {
        return infoWebClient.get()
            .uri { builder ->
                builder
                    .queryParam("KEY", apiProperties.serviceKey)
                    .queryParam("Type", "json")
                    .queryParam("SCHUL_NM", schoolName)
                    .build()
            }
            .retrieve()
            .bodyToMono(ApiInfoResponse::class.java)
            .mapNotNull(InfoResponse::from)
    }
}
