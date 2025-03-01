package com.timely.domain.info.service.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ApiInfoResponse(
    @JsonProperty("schoolInfo")
    val schoolInfo: List<SchoolInfo>
)

data class SchoolInfo(
    @JsonProperty("head")
    val head: List<Head>?,

    @JsonProperty("row")
    val row: List<Row>?
)

data class Head(
    @JsonProperty("list_total_count")
    val listTotalCount: Int?,

    @JsonProperty("RESULT")
    val result: Map<String, Any>?
)

data class Row(
    @JsonProperty("ATPT_OFCDC_SC_CODE")
    val ATPT_OFCDC_SC_CODE: String?,

    @JsonProperty("ATPT_OFCDC_SC_NM")
    val ATPT_OFCDC_SC_NM: String?,

    @JsonProperty("SD_SCHUL_CODE")
    val SD_SCHUL_CODE: String?,

    @JsonProperty("SCHUL_NM")
    val SCHUL_NM: String?,

    @JsonProperty("ENG_SCHUL_NM")
    val ENG_SCHUL_NM: String?,

    @JsonProperty("SCHUL_KND_SC_NM")
    val SCHUL_KND_SC_NM: String?,

    @JsonProperty("LCTN_SC_NM")
    val LCTN_SC_NM: String?,

    @JsonProperty("JU_ORG_NM")
    val JU_ORG_NM: String?,

    @JsonProperty("FOND_SC_NM")
    val FOND_SC_NM: String?,

    @JsonProperty("ORG_RDNZC")
    val ORG_RDNZC: String?,

    @JsonProperty("ORG_RDNMA")
    val ORG_RDNMA: String?,

    @JsonProperty("ORG_RDNDA")
    val ORG_RDNDA: String?,

    @JsonProperty("ORG_TELNO")
    val ORG_TELNO: String?,

    @JsonProperty("HMPG_ADRES")
    val HMPG_ADRES: String?,

    @JsonProperty("COEDU_SC_NM")
    val COEDU_SC_NM: String?,

    @JsonProperty("ORG_FAXNO")
    val ORG_FAXNO: String?,

    @JsonProperty("HS_SC_NM")
    val HS_SC_NM: String?,

    @JsonProperty("INDST_SPECL_CCCCL_EXST_YN")
    val INDST_SPECL_CCCCL_EXST_YN: String?,

    @JsonProperty("HS_GNRL_BUSNS_SC_NM")
    val HS_GNRL_BUSNS_SC_NM: String?,

    @JsonProperty("SPCLY_PURPS_HS_ORD_NM")
    val SPCLY_PURPS_HS_ORD_NM: String?,

    @JsonProperty("ENE_BFE_SEHF_SC_NM")
    val ENE_BFE_SEHF_SC_NM: String?,

    @JsonProperty("DGHT_SC_NM")
    val DGHT_SC_NM: String?,

    @JsonProperty("FOND_YMD")
    val FOND_YMD: String?,

    @JsonProperty("FOAS_MEMRD")
    val FOAS_MEMRD: String?,

    @JsonProperty("LOAD_DTM")
    val LOAD_DTM: String?
)
