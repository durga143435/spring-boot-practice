package com.example.client_credential_manual_token_refresh.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StringProccessorServiceTest {

    @Autowired
    StringProccessorService service;

    @Test
    public void testIsPalindrome_withValidInput(){
        boolean result = service.isPalindrome("adada");
        Assertions.assertTrue(result);
    }

    @Test
    public void testIsPalindrome_withInValidInput(){
        boolean result = service.isPalindrome("adadaaa");
        Assertions.assertFalse(result);
    }

    @Test
    public void testIsPalindrome_withNullInput(){
        boolean result = service.isPalindrome(null);
        Assertions.assertFalse(result);
    }
}