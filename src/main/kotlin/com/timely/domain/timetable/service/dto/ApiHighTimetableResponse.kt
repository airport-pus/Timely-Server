package com.timely.domain.timetable.service.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ApiHighTimetableResponse(
    @JsonProperty("hisTimetable")
    val hisTimetable: List<HisTimetable>?
)

data class HisTimetable(
    @JsonProperty("head")
    val head: List<HisHead>?,

    @JsonProperty("row")
    val row: List<HisRow>?
)

data class HisHead(
    @JsonProperty("list_total_count")
    val listTotalCount: Int?,

    @JsonProperty("RESULT")
    val result: HisResult?
)

data class HisResult(
    @JsonProperty("CODE")
    val code: String?,

    @JsonProperty("MESSAGE")
    val message: String?
)

data class HisRow(
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

    @JsonProperty("ORD_SC_NM")
    val ordScNm: String?,

    @JsonProperty("DDDEP_NM")
    val dddepNm: String?,

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
