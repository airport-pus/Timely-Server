package com.timely.common.exception

import org.springframework.http.HttpStatus

open class TimelyException(
    val status: HttpStatus,
    val errorCode: String,
    message: String? = null
) : RuntimeException(message)
