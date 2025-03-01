package com.timely.domain.timetable.exception

import com.timely.common.exception.TimelyException
import org.springframework.http.HttpStatus

class TimetableInvalidException : TimelyException(
    HttpStatus.BAD_REQUEST,
    "TIMETABLE_RESPONSE_TYPE_INVALID",
    "Timetable Response 타입이 일치하지 않습니다."
)