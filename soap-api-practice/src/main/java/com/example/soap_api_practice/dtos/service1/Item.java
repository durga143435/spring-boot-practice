package com.example.soap_api_practice.dtos.service1;

import com.example.soap_api_practice.constants.NameSpace;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

import java.math.BigDecimal;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {

    @XmlElement(name = "name", namespace = NameSpace.ORD_NS)
    private String name;

    @XmlElement(name = "price", namespace = NameSpace.ORD_NS)
    private Price price;
}
