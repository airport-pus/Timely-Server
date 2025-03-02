package com.timely.domain.timetable.exception

import com.timely.common.exception.TimelyException
import org.springframework.http.HttpStatus

class TimetableEmptyException : TimelyException(
    HttpStatus.BAD_REQUEST,
    "TIMETABLE_EMPTY",
    "시간표 데이터가 존재하지 않습니다."
)
