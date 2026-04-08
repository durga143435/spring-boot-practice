package com.example.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class OutboundService {

    @Async
    public void sendEmail(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Email: order placed successfully");
    }

}
