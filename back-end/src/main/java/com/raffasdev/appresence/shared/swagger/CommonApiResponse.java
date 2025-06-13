package com.raffasdev.appresence.shared.swagger;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ProblemDetail;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Requisição inválida", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
        @ApiResponse(responseCode = "422", description = "Erro de domínio", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class)))
})
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CommonApiResponse {
}
