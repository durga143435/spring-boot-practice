package org.example.controllers;

import lombok.AllArgsConstructor;
import org.example.configs.RabbitMqConfig;
import org.example.dtos.MessageDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/amqp")
public class PublishMessageController {

    private final RabbitTemplate template;

    @PostMapping("/publishToDirectExchange")
    public ResponseEntity publishToDirectExchane(@RequestBody MessageDto body,
                                                 @RequestHeader(name = "header1", required = false) String h1){
        template.convertAndSend(RabbitMqConfig.PICKING_EXCHANGE,null, body, message -> {
            message.getMessageProperties().setContentType("application/json");
            message.getMessageProperties().setHeader("header1", h1);
            return message;
        });

        return ResponseEntity.ok("Message published successfully");
    }

    @PostMapping("/publishToHeaderExchange")
    public ResponseEntity publishToHeaderExchane(@RequestBody MessageDto body,
                                                 @RequestHeader(name = "module-type", required = false) String type,
                                                 @RequestHeader(name = "priority", required = false) String priority,
                                                 @RequestHeader(name = "unit", required = false) String unit,
                                                 @RequestHeader(name = "whid", required = false) String whid){
       /* Map<String, Object> headers = Map.of(
                "module-type", type,
                "priority", priority,
                "unit", unit,
                "whid", whid
        );*/
        Map<String, Object> headers = new HashMap<>();
        headers.put( "module-type", type);
        headers.put(  "priority", priority);
        headers.put( "unit", unit);
        headers.put( "whid", whid);

        template.convertAndSend(RabbitMqConfig.RECEIVING_EXCHANGE,null, body, message -> {
            message.getMessageProperties().setContentType("application/json");
            message.getMessageProperties().setHeaders(headers);
            return message;
        });

        return ResponseEntity.ok("Message published to Header Exchange successfully");
    }


}
