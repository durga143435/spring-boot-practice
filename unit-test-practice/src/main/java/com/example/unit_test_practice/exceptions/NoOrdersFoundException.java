package com.example.unit_test_practice.exceptions;

public class NoOrdersFoundException extends RuntimeException{

    public NoOrdersFoundException(){
        super("No Orders Found");
    }
}
