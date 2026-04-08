package com.example.soap_api_practice.controllers;

import com.example.soap_api_practice.dtos.combinedResponseDtos.CombinedResponse;
import com.example.soap_api_practice.dtos.generatedService1Dtos.Service1Envelope;
import com.example.soap_api_practice.dtos.generatedService2Dtos.Service2Envelope;
import com.example.soap_api_practice.services.CombinedResponseService;
import com.example.soap_api_practice.utils.XMLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    private RestTemplate template;

    @Autowired
    private CombinedResponseService combinedResponseService;

    @GetMapping("/getService1")
    public ResponseEntity<Service1Envelope> getService1(){
//        ResponseEntity<String> res = template.exchange("http://localhost:8080/soap/service1", HttpMethod.GET, null, String.class );
//        return ResponseEntity.ok(XMLUtils.convertXmlToDto(res.getBody(), Service1Response.class));

        ResponseEntity<String> res = template.exchange("http://localhost:8080/soap/service1", HttpMethod.GET, null, String.class );
        return ResponseEntity.ok(XMLUtils.convertXmlToDto(res.getBody(), Service1Envelope.class));
    }

    @GetMapping("/getService2")
    public ResponseEntity<Service2Envelope> getService2() {
        ResponseEntity<String> res = template.exchange("http://localhost:8080/soap/service2", HttpMethod.GET, null, String.class );
        return ResponseEntity.ok(XMLUtils.convertXmlToDto(res.getBody(), Service2Envelope.class));
    }

    @GetMapping("/test")
    public String test(){
//        ResponseEntity<Service1Response> service1 = getService1();

        ResponseEntity<Service1Envelope> service1 = getService1();

        System.out.println("=================="+service1.getBody());
        return XMLUtils.convertDtoToXml(service1.getBody());
    }

    @GetMapping("/test2")
    public String test2(){

        ResponseEntity<Service2Envelope> service2 = getService2();

        System.out.println("=================="+service2.getBody());
        return XMLUtils.convertDtoToXml(service2.getBody());
    }

    @GetMapping("/getCombinedResponse")
    public ResponseEntity<CombinedResponse> combinedResponse(){
        Service1Envelope res1 = getService1().getBody();
        Service2Envelope res2 = getService2().getBody();
        CombinedResponse result = combinedResponseService.getCombinedResponse(res1, res2);
//        String xmlResponse = XMLUtils.convertDtoToXml(result);
        return  ResponseEntity.ok(result);

    }
}
