package com.example.client_credential_manual_token_refresh.services;

import org.springframework.stereotype.Service;

import java.time.Year;

@Service
public class DiscountService {

    public float calculateDiscount(float amount, String promoCode){
        if(amount == 0 || promoCode == null)
            return 0;
        if (promoCode.equals("ThanksGiving"))
            return amount*0.1f;
        if (promoCode.equals("Xmas") && getYear().getValue() == 2025)
            return amount*0.25f;
        return 0;
    }

    Year getYear() {
        return Year.now();
    }
}
