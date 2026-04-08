package org.example;

import org.apache.coyote.Response;
import org.example.dtos.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@ControllerAdvice
public class GlobalExceptions {

    @ExceptionHandler(WebClientResponseException.Forbidden.class)
    public ResponseEntity<ApiResponse> forbiddenHandler(Exception e){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ApiResponse.error(HttpStatus.FORBIDDEN.value(), e.getMessage()));
    }
}
