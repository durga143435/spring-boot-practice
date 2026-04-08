package com.example.unit_test_practice.exceptions;

public class CartNotFoundException extends RuntimeException{
    public CartNotFoundException(){
        super("Cart Not Found");
    }
}
