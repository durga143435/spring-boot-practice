package org.example.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauth")
public class OidcController {

    @GetMapping("/greetings")
    public ResponseEntity<String> sendGreeting(@RegisteredOAuth2AuthorizedClient("durga") OAuth2AuthorizedClient client){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();


        return ResponseEntity.ok("Hello");
    }

    @GetMapping("/success")
    public ResponseEntity<String> success() {
        return  ResponseEntity.ok("Success");
    }
}
