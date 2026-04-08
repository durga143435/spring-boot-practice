package com.example.unit_test_practice.exceptions;

public class CartEmptyException extends RuntimeException{

    public CartEmptyException() {
        super("Cart is Empty");
    }
}
