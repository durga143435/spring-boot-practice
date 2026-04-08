package com.example.soap_api_practice.services;

import com.example.soap_api_practice.dtos.combinedResponseDtos.CombinedResponse;
import com.example.soap_api_practice.dtos.generatedService1Dtos.Service1Envelope;
import com.example.soap_api_practice.dtos.generatedService2Dtos.Service2Envelope;
import com.example.soap_api_practice.mapper.CombinedResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CombinedResponseService {

    @Autowired
    CombinedResponseMapper mapper;
    public CombinedResponse getCombinedResponse(Service1Envelope res1, Service2Envelope res2){
        return mapper.formCombinedResponse(res1, res2);
    }
}
