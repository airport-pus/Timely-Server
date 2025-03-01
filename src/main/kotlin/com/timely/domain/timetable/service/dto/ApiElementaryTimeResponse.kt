package com.timely.domain.timetable.service.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ApiElementaryTimeResponse(
    @JsonProperty("elsTimetable")
    val elsTimetable: List<ElsTimetable>?
)

data class ElsTimetable(
    @JsonProperty("head")
    val head: List<ElsHead>?,

    @JsonProperty("row")
    val row: List<ElsRow>?
)

data class ElsHead(
    @JsonProperty("list_total_count")
    val listTotalCount: Int?,

    @JsonProperty("RESULT")
    val result: ElsResult?
)

data class ElsResult(
    @JsonProperty("CODE")
    val code: String?,

    @JsonProperty("MESSAGE")
    val message: String?
)

data class ElsRow(
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
