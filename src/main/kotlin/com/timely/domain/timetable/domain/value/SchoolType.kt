package com.timely.domain.timetable.domain.value

import com.timely.domain.timetable.exception.SchoolTypeInvalidException

enum class SchoolType {
    ELEMENTARY, MIDDLE, HIGH;

    companion object {
        fun from(value: String): SchoolType {
            return when (value.lowercase()) {
                "elementary", "초등학교" -> ELEMENTARY
                "middle", "중학교" -> MIDDLE
                "high", "고등학교" -> HIGH
                else -> throw SchoolTypeInvalidException()
            }
        }
    }
}

