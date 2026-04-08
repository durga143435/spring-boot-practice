package com.example.soap_api_practice.dtos.calsiDtos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

//@XmlRootElement(name = "AddResponse", namespace = "http://tempuri.org/")
@Data
//@XmlRootElement(name = "AddResponse", namespace = "http://tempuri.org/")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddResponse {

    @XmlElement(name = "AddResult", namespace = "http://tempuri.org/")
    int addResult;
}
