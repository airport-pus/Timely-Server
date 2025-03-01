package com.timely.domain.middle.controller.dto

import com.timely.domain.middle.service.dto.ApiMiddleTimetableResponse

data class MiddleTimeResponse(
    val timeSummary: List<Timetable>
) {
    companion object {
        fun from(response: ApiMiddleTimetableResponse): MiddleTimeResponse {
            val timeList = response.misTimetable
                ?.filter { it.row != null }
                ?.flatMap { elsTimetable ->
                    elsTimetable.row?.map { row ->
                        Timetable(
                            allTiYmd = row.allTiYmd ?: "",
                            perio = row.perio ?: "",
                            itrtCntnt = row.itrtCntnt ?: ""
                        )
                    } ?: emptyList()
                }
            return MiddleTimeResponse(timeList!!)
        }
    }
}

data class Timetable(
    val allTiYmd: String,
    val perio: String,
    val itrtCntnt: String
)
