package com.example.soap_api_practice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

@RestController
@RequestMapping("/soap")
public class SampleSoapServiceControllers {

    @GetMapping("/service1")
    public String service1(){

        return """
                <soapenv:Envelope\s
                    xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"\s
                    xmlns:ord="http://example.com/order"
                    xmlns:com="http://example.com/common">
                
                    <soapenv:Header>
                        <com:requestId>REQ-12345</com:requestId>
                        <com:timestamp>2026-04-04T10:30:00</com:timestamp>
                    </soapenv:Header>
                
                    <soapenv:Body>
                        <ord:getOrdersResponse>
                
                            <ord:status>
                                <ord:code>200</ord:code>
                                <ord:message>SUCCESS</ord:message>
                            </ord:status>
                
                            <ord:customer>
                                <ord:id>101</ord:id>
                                <ord:name>Durga</ord:name>
                                <ord:email>durga@example.com</ord:email>
                            </ord:customer>
                
                            <ord:orders>
                
                                <ord:order>
                                    <ord:id>1</ord:id>
                                    <ord:orderDate>2026-04-01</ord:orderDate>
                
                                    <ord:items>
                                        <ord:item>
                                            <ord:name>Book</ord:name>
                                            <ord:price currency="INR">100</ord:price>
                                        </ord:item>
                                        <ord:item>
                                            <ord:name>Pen</ord:name>
                                            <ord:price currency="INR">20</ord:price>
                                        </ord:item>
                                    </ord:items>
                
                                    <ord:shipping>
                                        <ord:address>
                                            <ord:city>Chennai</ord:city>
                                            <ord:pinCode>600001</ord:pinCode>
                                        </ord:address>
                                    </ord:shipping>
                
                                </ord:order>
                
                                <ord:order>
                                    <ord:id>2</ord:id>
                                    <ord:orderDate>2026-04-02</ord:orderDate>
                
                                    <ord:items>
                                        <ord:item>
                                            <ord:name>Bag</ord:name>
                                            <ord:price currency="INR">500</ord:price>
                                        </ord:item>
                                    </ord:items>
                
                                    <ord:shipping>
                                        <ord:address>
                                            <ord:city>Bangalore</ord:city>
                                            <ord:pinCode>560001</ord:pinCode>
                                        </ord:address>
                                    </ord:shipping>
                
                                </ord:order>
                
                            </ord:orders>
                
                        </ord:getOrdersResponse>
                    </soapenv:Body>
                </soapenv:Envelope>
                """;
    }

    @GetMapping("/service2")
    public String service2(){
        return """
                <soapenv:Envelope\s
                    xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                    xmlns:ord="http://example.com/order"
                    xmlns:com="http://example.com/common">
                    <soapenv:Header>
                        <com:ResponseHeader>
                            <com:requestId>REQ-12345</com:requestId>
                            <com:status>SUCCESS</com:status>
                            <com:timestamp>2026-04-05T10:15:35</com:timestamp>
                        </com:ResponseHeader>
                    </soapenv:Header>
                    <soapenv:Body>
                        <ord:CreateOrderResponse>
                            <ord:orderId>ORD-999</ord:orderId>
                            <ord:status>CONFIRMED</ord:status>
                            <ord:summary>
                                <ord:totalItems>2</ord:totalItems>
                                <ord:totalAmount currency="INR">76000</ord:totalAmount>
                            </ord:summary>
                            <ord:shipment>
                                <ord:shipmentId>SHP123</ord:shipmentId>
                                <ord:carrier>BlueDart</ord:carrier>
                                <ord:estimatedDelivery>2026-04-08</ord:estimatedDelivery>
                                <ord:trackingEvents>
                                    <ord:event>
                                        <ord:status>DISPATCHED</ord:status>
                                        <ord:location>Chennai</ord:location>
                                        <ord:time>2026-04-05T12:00:00</ord:time>
                                    </ord:event>
                                    <ord:event>
                                        <ord:status>IN_TRANSIT</ord:status>
                                        <ord:location>Bangalore</ord:location>
                                        <ord:time>2026-04-06T09:00:00</ord:time>
                                    </ord:event>
                                </ord:trackingEvents>
                            </ord:shipment>
                            <ord:warnings>
                                <ord:warning code="LOW_STOCK">
                                    <ord:message>One item has limited stock</ord:message>
                                </ord:warning>
                            </ord:warnings>
                        </ord:CreateOrderResponse>
                    </soapenv:Body>
                </soapenv:Envelope>
                """;
    }
}
