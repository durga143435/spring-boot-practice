package com.example.soap_api_practice.dtos.service1;

import com.example.soap_api_practice.constants.NameSpace;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Shipping {

    @XmlElement(name = "address", namespace = NameSpace.ORD_NS)
   private Address address;
}
