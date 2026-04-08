package org.example.controllers;

import lombok.AllArgsConstructor;
import org.example.dtos.MessageDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
public class TypesOfExchangesController {

    private final RabbitTemplate template;

    @PostMapping("/defaultExchange")
    public ResponseEntity<String> defaultExchange(@RequestBody MessageDto dto){
        template.convertAndSend("default.Q1", dto);
        return ResponseEntity.ok("Msg published to default is successful");
    }

    @PostMapping("/directExchange")
    public ResponseEntity<String> directExchange(@RequestBody MessageDto dto){
        template.convertAndSend("direct.ex1","cust_routing", dto);
        return ResponseEntity.ok("Msg published to dierct is successful");
    }

    @PostMapping("/topicExchange")
    public ResponseEntity<String> topicExchange(@RequestBody MessageDto dto,
                                                 @RequestHeader(name = "routingKey", required = false) String routingKey){
        System.out.println("routing key: "+routingKey);
        template.convertAndSend("topic.ex1",routingKey, dto);
        return ResponseEntity.ok("Msg published to topic is successful");
    }

    @PostMapping("/headerExchange")
    public ResponseEntity<String> HeaderExchange(@RequestBody MessageDto dto,
//                                                 @RequestHeader(name = "type", required = false) String type
                                                 @RequestHeader Map<String, Object> headers) {

       try{
           template.convertAndSend("header.ex1", null, dto, message -> {
               message.getMessageProperties().setHeaders(headers);
               return message;
           });
       } catch (Exception e){
           System.out.println("Exception occured, reverting the changes");
           return ResponseEntity.ok("Server Down, Msg not published, try again after sometime");
       }
        return ResponseEntity.ok("Message successfully published");

    }


}
