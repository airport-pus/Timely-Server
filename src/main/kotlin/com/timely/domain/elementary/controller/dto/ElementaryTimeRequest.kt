package com.timely.domain.elementary.controller.dto

data class ElementaryTimeRequest(
    val atptOfcdcScCode: String,
    val sdSchulCode: String,
    val grade: String,
    val classNm: String,
    val startYmd: String,
    val endYmd: String
)
