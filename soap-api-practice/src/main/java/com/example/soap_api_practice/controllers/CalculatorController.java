package com.example.soap_api_practice.controllers;

import com.example.soap_api_practice.dtos.calsiDtos.CalsiRequest;
import com.example.soap_api_practice.dtos.calsiDtos.CalsiResponse;
import com.example.soap_api_practice.services.CalsiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calsi")
public class CalculatorController {

    @Autowired
    CalsiService calsiService;

    @PostMapping("/add")
    public CalsiResponse add(@RequestBody CalsiRequest request){
       return calsiService.add(request);
    }
}
