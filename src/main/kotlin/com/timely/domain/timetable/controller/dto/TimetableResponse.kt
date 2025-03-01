package com.timely.domain.timetable.controller.dto

import com.timely.domain.timetable.service.dto.ApiElementaryTimeResponse
import com.timely.domain.timetable.service.dto.ApiMiddleTimetableResponse
import com.timely.domain.timetable.service.dto.ApiHighTimetableResponse

data class TimetableResponse(
    val timeSummary: List<Timetable>
) {
    companion object {
        fun from(response: ApiElementaryTimeResponse): TimetableResponse {
            val timeList = response.elsTimetable
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
            return TimetableResponse(timeList ?: emptyList())
        }

        fun from(response: ApiMiddleTimetableResponse): TimetableResponse {
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
            return TimetableResponse(timeList ?: emptyList())
        }

        fun from(response: ApiHighTimetableResponse): TimetableResponse {
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
            return TimetableResponse(timeList ?: emptyList())
        }
    }
}

data class Timetable(
    val allTiYmd: String,
    val perio: String,
    val itrtCntnt: String
)
