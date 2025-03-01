package com.timely.domain.high.controller.dto

import com.timely.domain.high.service.dto.ApiHighTimetableResponse

data class HighTimeResponse(
    val timeSummary: List<Timetable>
) {
    companion object {
        fun from(response: ApiHighTimetableResponse): HighTimeResponse {
            val timeList = response.hisTimetable
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
            return HighTimeResponse(timeList!!)
        }
    }
}

data class Timetable(
    val allTiYmd: String,
    val perio: String,
    val itrtCntnt: String
)
