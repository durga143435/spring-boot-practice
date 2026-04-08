package com.example.client_credential_manual_token_refresh.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.concurrent.ConcurrentHashMap;

@ExtendWith(MockitoExtension.class)
class AuthTokenTest {

    @Mock
    AuthToken authToken;

    @Test
    void generateTokenShouldGenerateTheTokenTest(){

        ConcurrentHashMap token = new ConcurrentHashMap<>();
        token.put("accessToken", "tokenValue123");
        token.put("expiry", System.currentTimeMillis()+10000);

       String accessToken = authToken.getAccessToken();

        Assertions.assertEquals(token.get("accessToken"), accessToken);
        System.out.println("assertion passed");

    }

    /*public String getAccessToken(){
        if(StringUtil.notNullNorEmpty(token.get("accessToken")) && isNotExpired())
            return token.get("accessToken");

        System.out.println("token expired/null generating new one");
        generateToken();
        return token.get("accessToken");

    }*/
}