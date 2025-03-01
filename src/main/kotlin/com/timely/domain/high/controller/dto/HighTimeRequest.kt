package com.timely.domain.high.controller.dto

data class HighTimeRequest(
    val atptOfcdcScCode: String,
    val sdSchulCode: String,
    val grade: String,
    val classNm: String,
    val startYmd: String,
    val endYmd: String
)
