package com.example.unit_test_practice.exceptions;

public class PaymentException extends RuntimeException {
    public PaymentException(String message){
        super(message);
    }

    public PaymentException(){

    }

}
