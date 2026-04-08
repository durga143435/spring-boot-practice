package com.example.soap_api_practice.dtos.calsiDtos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/*@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "AddResponse", namespace = "http://tempuri.org/")
@XmlAccessorType(XmlAccessType.FIELD)
public class CalsiResponse {

    @XmlElement(name = "AddResult", namespace = "http://tempuri.org/")
    Integer addResult;
}*/


@Data
@XmlRootElement(name="Envelope", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
@XmlAccessorType(XmlAccessType.FIELD)
public class CalsiResponse{

    @XmlElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    private CalsiResponseBody body;



}