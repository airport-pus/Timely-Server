package com.timely.domain.info.controller.dto

import com.timely.domain.info.service.dto.ApiInfoResponse

data class InfoResponse(
    val ATPT_OFCDC_SC_CODE: String,
    val SD_SCHUL_CODE: String,
    val SCHUL_KND_SC_NM: String
) {
    companion object {
        fun from(apiResponse: ApiInfoResponse): InfoResponse? {
            val row = apiResponse.schoolInfo
                .firstOrNull { it.row?.isNotEmpty() == true }

            return row?.row?.firstOrNull()?.let {
                InfoResponse(
                    ATPT_OFCDC_SC_CODE = it.ATPT_OFCDC_SC_CODE ?: "",
                    SD_SCHUL_CODE = it.SD_SCHUL_CODE ?: "",
                    SCHUL_KND_SC_NM = it.SCHUL_KND_SC_NM ?: ""
                )
            }
        }
    }
}
