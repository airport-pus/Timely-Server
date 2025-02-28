package com.timely.domain.schoolInfo.controller.dto

import com.timely.domain.schoolInfo.service.dto.ApiSchoolInfoResponse

data class SchoolInfoResponse(
    val ATPT_OFCDC_SC_CODE: String,
    val SD_SCHUL_CODE: String
) {
    companion object {
        fun from(apiResponse: ApiSchoolInfoResponse): SchoolInfoResponse? {
            val row = apiResponse.schoolInfo
                .firstOrNull { it.row?.isNotEmpty() == true }

            return row?.row?.firstOrNull()?.let {
                SchoolInfoResponse(
                    ATPT_OFCDC_SC_CODE = it.ATPT_OFCDC_SC_CODE ?: "",
                    SD_SCHUL_CODE = it.SD_SCHUL_CODE ?: ""
                )
            }
        }
    }
}
