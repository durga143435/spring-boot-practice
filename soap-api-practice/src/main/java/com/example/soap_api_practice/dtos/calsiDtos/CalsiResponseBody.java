package com.example.soap_api_practice.dtos.calsiDtos;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class CalsiResponseBody {

    @XmlElement(name ="AddResponse", namespace = "http://tempuri.org/")
    private AddResponse addResponse;
}
