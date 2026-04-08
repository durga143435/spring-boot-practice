package org.example.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauth")
public class CCController {

    @PreAuthorize("hasRole('api.read')")
    @GetMapping("/greetings")
    public ResponseEntity<String> sendGreeting(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);

        return ResponseEntity.ok("Hello");
    }

    @PreAuthorize("hasRole('api.write')")
    @GetMapping("/success")
    public ResponseEntity<String> success() {
        return  ResponseEntity.ok("Success");
    }
}
