package com.timely.domain.timetable.controller.dto

data class TimetableRequest(
    val schoolType: String,
    val atptOfcdcScCode: String,
    val sdSchulCode: String,
    val grade: String,
    val classNm: String,
    val startYmd: String,
    val endYmd: String
)
