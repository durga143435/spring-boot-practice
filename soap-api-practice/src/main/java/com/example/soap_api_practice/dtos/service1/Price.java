package com.example.soap_api_practice.dtos.service1;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Price {

    @XmlAttribute(name = "currency")
    private String currency;

    //similarly you can mention other attributes mapped to Price tag if applicable like and value property will be mentioned only once
//    @XmlAttribute(name = "attr1")
//    private String attr1;

    @XmlValue
    private String value;
}
