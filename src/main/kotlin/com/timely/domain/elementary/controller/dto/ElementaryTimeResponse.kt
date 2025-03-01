package com.timely.domain.elementary.controller.dto

import com.timely.domain.elementary.service.dto.ApiElementaryTimeResponse

data class ElementaryTimeResponse(
    val timeSummary: List<Timetable>
) {
    companion object {
        fun from(response: ApiElementaryTimeResponse): ElementaryTimeResponse {
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
            return ElementaryTimeResponse(timeList!!)
        }
    }
}

data class Timetable(
    val allTiYmd: String,
    val perio: String,
    val itrtCntnt: String
)
