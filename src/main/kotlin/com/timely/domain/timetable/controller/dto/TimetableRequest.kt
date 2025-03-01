package com.timely.domain.timetable.controller.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "시간표 조회 요청 데이터")
data class TimetableRequest(
    @Schema(description = "학교 유형", example = "고등학교", required = true)
    val schoolType: String,

    @Schema(description = "교육청 코드", example = "C10", required = true)
    val atptOfcdcScCode: String,

    @Schema(description = "학교 코드", example = "7150658", required = true)
    val sdSchulCode: String,

    @Schema(description = "학년", example = "3", required = true)
    val grade: String,

    @Schema(description = "반 이름", example = "1", required = true)
    val classNm: String,

    @Schema(description = "시작 날짜 (YYYYMMDD 형식)", example = "20240701", required = true)
    val startYmd: String,

    @Schema(description = "종료 날짜 (YYYYMMDD 형식)", example = "20240706", required = true)
    val endYmd: String
)
