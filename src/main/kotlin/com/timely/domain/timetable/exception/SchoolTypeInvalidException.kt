package com.timely.domain.timetable.exception

import com.timely.common.exception.TimelyException
import org.springframework.http.HttpStatus

class SchoolTypeInvalidException : TimelyException(
    HttpStatus.BAD_REQUEST,
    "SCHOOL_TYPE_INVALID",
    "학교 타입이 일치하지 않습니다."
)