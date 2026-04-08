package org.example.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.nio.channels.AcceptPendingException;
import java.nio.file.AccessDeniedException;

@RestController
@AllArgsConstructor
public class TokenRefreshController {

    private final WebClient webClient;

    @GetMapping("/test")
    public ResponseEntity<String> refresh(){
        String response = webClient.get()
                .uri("http://localhost:8081/oauth/success")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return ResponseEntity.ok(response);
    }

}
