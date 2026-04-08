package com.example.soap_api_practice.dtos.service1;

import com.example.soap_api_practice.constants.NameSpace;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Status {
    @XmlElement(name = "code", namespace = NameSpace.ORD_NS)
    private Integer code;

    @XmlElement(name = "message", namespace = NameSpace.ORD_NS)
    private String message;

    @XmlElement(name = "myField", namespace = NameSpace.ORD_NS)
    private String myField;
}
