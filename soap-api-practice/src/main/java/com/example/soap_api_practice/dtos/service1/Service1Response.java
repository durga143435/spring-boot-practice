package com.example.soap_api_practice.dtos.service1;

import com.example.soap_api_practice.constants.NameSpace;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "Envelope", namespace = NameSpace.SOAP_ENV_NS)
@XmlAccessorType(XmlAccessType.FIELD)
public class Service1Response {

    @XmlElement(name = "Body", namespace = NameSpace.SOAP_ENV_NS)
    private Service1Body Body;
}
