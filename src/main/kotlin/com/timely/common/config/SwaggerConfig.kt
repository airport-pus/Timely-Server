package com.timely.common.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.servers.Server
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@OpenAPIDefinition(
    info = Info(
        title = "Timely API 문서",
        description = """
            ### 상태 코드 및 오류 메시지 형식:
            | 상태 코드 | 오류 코드 | 설명 |
            | --- | --- | --- |
            | 400 | INVALID_ARGUMENT | 잘못된 값이 들어왔습니다. |
            | 400 | TYPE_MISMATCH | 파라미터 타입이 일치하지 않습니다. |
            | 400 | NULL_VALUE | 필수 값이 누락되었습니다. |
            | 400 | TIMETABLE_RESPONSE_TYPE_INVALID | Timetable Response 타입이 일치하지 않습니다. |
            | 400 | SCHOOL_TYPE_INVALID | 학교 타입이 일치하지 않습니다. |
            | 400 | TIMETABLE_EMPTY | 시간표 데이터가 존재하지 않습니다. |
            | 500 | SERVER_UNKNOWN | 서버에서 알 수 없는 에러가 발생했습니다. |
            
            ### 오류 메시지 예시:
            ```json
            {
              "status": 403,
              "errorCode": "NULL_VALUE",
              "message": "필수 값이 누락되었습니다.",
              "timestamp": "2024-09-29T10:00:00"
            }
            ```
        """
    )
)
class SwaggerConfig {

    @Bean
    fun openAPI(): OpenAPI {
        return OpenAPI()
            .addServersItem(Server().url("/").description("API Server"))
    }
}
