package com.timely.domain.middle.service.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ApiMiddleTimetableResponse(
    @JsonProperty("misTimetable")
    val misTimetable: List<MisTimetable>?
)

data class MisTimetable(
    @JsonProperty("head")
    val head: List<Head>?,

    @JsonProperty("row")
    val row: List<Row>?
)

data class Head(
    @JsonProperty("list_total_count")
    val listTotalCount: Int?,

    @JsonProperty("RESULT")
    val result: Result?
)

data class Result(
    @JsonProperty("CODE")
    val code: String?,

    @JsonProperty("MESSAGE")
    val message: String?
)

data class Row(
    @JsonProperty("ATPT_OFCDC_SC_CODE")
    val atptOfcdcScCode: String?,

    @JsonProperty("ATPT_OFCDC_SC_NM")
    val atptOfcdcScNm: String?,

    @JsonProperty("SD_SCHUL_CODE")
    val sdSchulCode: String?,

    @JsonProperty("SCHUL_NM")
    val schulNm: String?,

    @JsonProperty("AY")
    val ay: String?,

    @JsonProperty("SEM")
    val sem: String?,

    @JsonProperty("ALL_TI_YMD")
    val allTiYmd: String?,

    @JsonProperty("DGHT_CRSE_SC_NM")
    val dghtCrseScNm: String?,

    @JsonProperty("GRADE")
    val grade: String?,

    @JsonProperty("CLASS_NM")
    val classNm: String?,

    @JsonProperty("PERIO")
    val perio: String?,

    @JsonProperty("ITRT_CNTNT")
    val itrtCntnt: String?,

    @JsonProperty("LOAD_DTM")
    val loadDtm: String?
)
