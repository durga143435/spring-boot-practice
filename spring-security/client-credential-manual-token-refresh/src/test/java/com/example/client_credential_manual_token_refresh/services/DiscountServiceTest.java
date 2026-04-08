package com.example.client_credential_manual_token_refresh.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DiscountServiceTest {

    @MockitoSpyBean
    DiscountService discountService;

    @Test
    public void testCalculateDiscount_ValidPromoCode(){
        float result = discountService.calculateDiscount(100, "ThanksGiving");
        Assertions.assertEquals(10f, result);
    }

    @Test
    public void testCalculateDiscount_ValidPromoCodeFor2025Year(){
        Mockito.when(discountService.getYear()).thenReturn(Year.of(2025));
        float result = discountService.calculateDiscount(100, "Xmas");
        Assertions.assertEquals(25f, result);
    }

    @Test
    public void testCalculateDiscount_nullInput(){
        float result = discountService.calculateDiscount(100, null);
        Assertions.assertEquals(0f, result);
    }
}