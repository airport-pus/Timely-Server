package com.timely.domain.timetable.domain.value

import com.timely.domain.timetable.exception.SchoolTypeInvalidException

enum class SchoolType {
    ELEMENTARY, MIDDLE, HIGH;

    companion object {
        fun from(value: String): SchoolType {
            return entries.find { it.name.equals(value, ignoreCase = true) }
                ?: throw SchoolTypeInvalidException()
        }
    }
}
