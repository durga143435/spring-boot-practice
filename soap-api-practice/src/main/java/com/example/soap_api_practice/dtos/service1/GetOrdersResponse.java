package com.example.soap_api_practice.dtos.service1;

import com.example.soap_api_practice.constants.NameSpace;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import lombok.Data;

import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class GetOrdersResponse {

    @XmlElement(name = "status", namespace = NameSpace.ORD_NS)
    private Status status;

    @XmlElement(name = "customer", namespace = NameSpace.ORD_NS)
    private Customer customer;

    @XmlElementWrapper(name = "orders", namespace = NameSpace.ORD_NS)
    @XmlElement(name = "order", namespace = NameSpace.ORD_NS)
    private List<Order> orders;

}
