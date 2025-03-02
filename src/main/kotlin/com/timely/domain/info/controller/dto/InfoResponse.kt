package com.timely.domain.info.controller.dto

import com.timely.domain.info.service.dto.ApiInfoResponse
import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "학교 정보 응답 데이터")
data class InfoResponse(
    @Schema(description = "시도 교육청 코드", example = "C10", required = true)
    val atptOfcdcScCode: String,

    @Schema(description = "행정 표준 코드", example = "7150658", required = true)
    val sdSchulCode: String,

    @Schema(description = "학교 종류 이름", example = "고등학교", required = true)
    val schulKndScNm: String
) {
    companion object {
        fun from(apiResponse: ApiInfoResponse): InfoResponse? {
            val row = apiResponse.schoolInfo
                .firstOrNull { it.row?.isNotEmpty() == true }

            return row?.row?.firstOrNull()?.let {
                InfoResponse(
                    atptOfcdcScCode = it.ATPT_OFCDC_SC_CODE ?: "",
                    sdSchulCode = it.SD_SCHUL_CODE ?: "",
                    schulKndScNm = it.SCHUL_KND_SC_NM ?: ""
                )
            }
        }
    }
}
