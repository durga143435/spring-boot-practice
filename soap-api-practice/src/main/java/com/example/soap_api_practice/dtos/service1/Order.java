package com.example.soap_api_practice.dtos.service1;

import com.example.soap_api_practice.constants.NameSpace;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Order {

    @XmlElement(name = "id", namespace = NameSpace.ORD_NS)
    private Integer id;

    @XmlElement(name = "orderDate", namespace = NameSpace.ORD_NS)
    private Date orderDate;

    @XmlElementWrapper(name = "items", namespace = NameSpace.ORD_NS)
    @XmlElement(name = "item", namespace = NameSpace.ORD_NS)
    private List<Item> items;

    @XmlElement(name = "shipping", namespace = NameSpace.ORD_NS)
    private Shipping shipping;


}
