package com.example.soap_api_practice;

import com.example.soap_api_practice.dtos.service1.Service1Response;
import com.example.soap_api_practice.utils.XMLUtils;

public class Test {

    public static void main(String[] args) {
        System.out.println(XMLUtils.convertDtoToXml(new Service1Response()));

    }
}
