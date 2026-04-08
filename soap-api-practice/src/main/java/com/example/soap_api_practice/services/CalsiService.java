package com.example.soap_api_practice.services;

import com.example.soap_api_practice.dtos.calsiDtos.CalsiRequest;
import com.example.soap_api_practice.dtos.calsiDtos.CalsiResponse;
import com.example.soap_api_practice.utils.XMLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CalsiService {

    @Autowired
    RestTemplate template;



    public CalsiResponse add(CalsiRequest request){

        String soapRequest = getSoapRequest(request);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "text/xml");
        headers.set("Accept", "text/xml");
//        headers.setContentType(MediaType.TEXT_XML);
        headers.set("SOAPAction","http://tempuri.org/Add");

        HttpEntity<String> entity = new HttpEntity(soapRequest, headers);

        System.out.println(entity);
        System.out.println(template.getRequestFactory().getClass());
        String soapResponse = template.exchange("http://www.dneonline.com/calculator.asmx", HttpMethod.POST, entity, String.class).getBody();
//        return  parseSoapResponse(soapResponse);

        return XMLUtils.convertXmlToDto(soapResponse, CalsiResponse.class);
    }

    private String getSoapRequest(CalsiRequest request) {
        return """
                <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                                          xmlns:tem="http://tempuri.org/">
                           <soapenv:Header/>
                           <soapenv:Body>
                              <tem:Add>
                                 <tem:intA>%d</tem:intA>
                                 <tem:intB>%d</tem:intB>
                              </tem:Add>
                           </soapenv:Body>
                        </soapenv:Envelope>
                """.formatted(request.getA(), request.getB());

    }

  /*  public CalsiResponse parseSoapResponse(String soapResponse){
        int startIndex =soapResponse.indexOf("<AddResult>")+ "<AddResult>".length();

        int endIndex = soapResponse.indexOf("</AddResult>");
        String result = soapResponse.substring(startIndex, endIndex);
        System.out.println(result);
        return new CalsiResponse(Integer.parseInt(result));

    }*/
}
