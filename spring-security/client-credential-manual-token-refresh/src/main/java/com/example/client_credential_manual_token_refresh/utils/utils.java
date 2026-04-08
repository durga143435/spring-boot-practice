package com.example.client_credential_manual_token_refresh.utils;

import com.example.client_credential_manual_token_refresh.services.AuthToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class utils {

    @Autowired
    AuthToken token;

    @Scheduled(fixedRate = 45*60*1000, initialDelay = 5000)
    public void generateToken() {
        token.generateToken();
        System.out.println("============================= generated from schedular");
    }
}
