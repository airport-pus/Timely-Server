package com.timely.domain.timetable.controller.dto

import com.timely.domain.timetable.service.dto.ApiElementaryTimeResponse
import com.timely.domain.timetable.service.dto.ApiMiddleTimetableResponse
import com.timely.domain.timetable.service.dto.ApiHighTimetableResponse
import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "시간표 응답 데이터")
data class TimetableResponse(
    @Schema(description = "시간표 리스트", required = true)
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

@Schema(description = "시간표 항목")
data class Timetable(
    @Schema(description = "시간표 날짜", example = "20250301", required = true)
    val allTiYmd: String,

    @Schema(description = "교시", example = "1", required = true)
    val perio: String,

    @Schema(description = "수업 내용", example = "수학", required = true)
    val itrtCntnt: String
)
