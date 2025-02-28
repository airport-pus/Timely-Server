package com.timely.common.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfig(private val apiProperties: ApiProperties) {

    @Bean
    fun infoWebClient(): WebClient {
        return WebClient.builder()
            .baseUrl(apiProperties.infoBaseUrl)
            .build()
    }

    @Bean
    fun elementaryWebClient(): WebClient {
        return WebClient.builder()
            .baseUrl(apiProperties.elementaryBaseUrl)
            .build()
    }

    @Bean
    fun middleWebClient(): WebClient {
        return WebClient.builder()
            .baseUrl(apiProperties.middleBaseUrl)
            .build()
    }

    @Bean
    fun highWebClient(): WebClient {
        return WebClient.builder()
            .baseUrl(apiProperties.highBaseUrl)
            .build()
    }
}
