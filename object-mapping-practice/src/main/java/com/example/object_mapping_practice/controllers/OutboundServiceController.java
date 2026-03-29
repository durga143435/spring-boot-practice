package com.example.object_mapping_practice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OutboundServiceController {

    @GetMapping("/getUserAccDetails")
    public ResponseEntity<String> getUserAccDetails() {
        String res = """
                {
                  "userId": "U12345",
                  "user_name": "Durga",
                  "email": "durga@example.com",
                  "isActive": true,
                  "profile": {
                    "firstName": "Durga",
                    "lastName": "Jagu",
                    "phone_number": "+91-9876543210",
                    "address": {
                      "street": "12, Main Road",
                      "city": "Chennai",
                      "state": "Tamil Nadu",
                      "postal_code": "600001"
                    }
                  },
                  "accounts": [
                    {
                      "account_id": "A1001",
                      "account_name": "Savings Account",
                      "balance": 15000.75,
                      "currency": "INR",
                      "transactions": [
                        {
                          "txn_id": "T1",
                          "amount": 500,
                          "txn_type": "DEBIT",
                          "txn_date": "2026-03-20"
                        },
                        {
                          "txn_id": "T2",
                          "amount": 2000,
                          "txn_type": "CREDIT",
                          "txn_date": "2026-03-22"
                        }
                      ]
                    },
                    {
                      "account_id": "A1001",
                      "account_name": "Current Account",
                      "balance": 25000,
                      "currency": "INR",
                      "transactions": [
                        {
                          "txn_id": "T3",
                          "amount": 1000,
                          "txn_type": "DEBIT",
                          "txn_date": "2026-03-21"
                        }
                      ]
                    }
                  ]
                }
                """;
        return ResponseEntity.ok(res);
    }

    @GetMapping("/getOrderDetails")
    public ResponseEntity<String> getOrderDetails(){

        String res = """
                {
                  "orderId": "143143",
                  "order_date": "2026-03-25",
                  "isActive": false,
                  "customObj": {
                        "custProp2": "value2"
                    },
                  "customer": {
                    "customer_id": "C100",
                    "customer_name": "Durga Jagu",
                    "contact": {
                      "email": "durga@example.com",
                      "phone_number": "+91-9876543210"
                    }
                  },
                  "order_status": "SHIPPED",
                  "items": [
                    {
                      "item_id": "I101",
                      "product_name": "Laptop",
                      "quantity": 1,
                      "price": 55000,
                      "specs": {
                        "brand": "Dell",
                        "ram": "16GB",
                        "storage": "512GB SSD"
                      }
                    },
                    {
                      "item_id": "I102",
                      "product_name": "Mouse",
                      "quantity": 2,
                      "price": 500,
                      "specs": {
                        "brand": "Logitech",
                        "type": "Wireless"
                      }
                    }
                  ],
                  "shipment": {
                    "shipment_id": "SHP123",
                    "delivery_address": {
                      "street": "12, Main Road",
                      "city": "Chennai",
                      "state": "Tamil Nadu",
                      "postal_code": "600001"
                    },
                    "tracking_history": [
                      {
                        "status": "ORDER_PLACED",
                        "timestamp": "2026-03-25T10:00:00"
                      },
                      {
                        "status": "SHIPPED",
                        "timestamp": "2026-03-26T15:30:00"
                      }
                    ]
                  }
                }
                """;

        return ResponseEntity.ok(res);
    }



}

