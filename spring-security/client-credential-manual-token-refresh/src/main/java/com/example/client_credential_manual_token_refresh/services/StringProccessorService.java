package com.example.client_credential_manual_token_refresh.services;

import org.apache.logging.log4j.util.StringBuilders;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class StringProccessorService {

    public boolean isPalindrome(String input){
        if(input == null)
            return false;

        String reversedInput = new StringBuilder(input).reverse().toString();
        return input.equals(reversedInput);
    }
}
