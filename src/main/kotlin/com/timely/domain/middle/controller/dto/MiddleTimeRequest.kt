package com.timely.domain.middle.controller.dto

data class MiddleTimeRequest(
    val atptOfcdcScCode: String,
    val sdSchulCode: String,
    val grade: String,
    val classNm: String,
    val startYmd: String,
    val endYmd: String
)
