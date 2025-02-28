package com.timely.common.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.bind.ConstructorBinding

@ConfigurationProperties(prefix = "spring.api")
data class ApiProperties @ConstructorBinding constructor(

    val serviceKey: String,
    val infoBaseUrl: String,
    val elementaryBaseUrl: String,
    val middleBaseUrl: String,
    val highBaseUrl: String
)
