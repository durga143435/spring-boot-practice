package com.example.client_credential_manual_token_refresh.controllers;

import com.example.client_credential_manual_token_refresh.services.AuthToken;
import com.example.client_credential_manual_token_refresh.config.AuthProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;

@RestController
public class Test {
   @Autowired
    AuthProps authProps;

   @Autowired
   RestTemplate template;

   @Autowired
   AuthToken authToken;


   @GetMapping("/getToken")
    public String token(){
       return authToken.getAccessToken();
   }

    @GetMapping("/getTokenDetails")
    public Map<String, String> details(){

        return authToken.tokenDetails();
    }


}
