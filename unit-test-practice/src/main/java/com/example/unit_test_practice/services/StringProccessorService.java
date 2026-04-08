package com.example.unit_test_practice.services;

import org.springframework.stereotype.Service;

@Service
public class StringProccessorService {

    public boolean isPalindrome(String input){
        if(input == null)
            return false;

        String reversedInput = new StringBuilder(input).reverse().toString();
        return input.equals(reversedInput);
    }
}
