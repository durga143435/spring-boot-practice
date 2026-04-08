package com.example.client_credential_manual_token_refresh.services;

import ch.qos.logback.core.util.StringUtil;
import com.example.client_credential_manual_token_refresh.config.AuthProps;
import com.example.client_credential_manual_token_refresh.dtos.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class AuthToken {

    @Autowired
    private RestTemplate template;

    @Autowired
    private AuthProps authProps;

    private static ConcurrentHashMap<String, String> token = new ConcurrentHashMap<>();


    public String getAccessToken(){
        if(StringUtil.notNullNorEmpty(token.get("accessToken")) && isNotExpired())
            return token.get("accessToken");

        System.out.println("token expired/null generating new one");
        generateToken();
        return token.get("accessToken");

    }

    public void generateToken(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> body = new LinkedMultiValueMap();
//        body.setAll(authProps.getAuthHeaders());

        body.add("client_id", authProps.getAuthHeaders().get("client_id"));
        body.add("client_secret", authProps.getAuthHeaders().get("client_secret"));
        body.add("grant_type", authProps.getAuthHeaders().get("grant_type"));
        body.add("scope", authProps.getAuthHeaders().get("scope"));
        HttpEntity<MultiValueMap<String,String>> entity = new HttpEntity<>(body, headers);

        ResponseEntity<TokenResponse> tokenResponse = template.exchange(authProps.getTokenUri(), HttpMethod.POST, entity, TokenResponse.class);

        if(tokenResponse != null){
            token.put("expiry", (System.currentTimeMillis()/1000 + tokenResponse.getBody().getExpiry())+"");
            token.put("accessToken", tokenResponse.getBody().getAccessToken());
        }
    }

    public static boolean isNotExpired(){
        return System.currentTimeMillis()/1000 < Integer.parseInt(token.get("expiry"));
    }

    public Map<String, String> tokenDetails(){
        return token;
    }

}
