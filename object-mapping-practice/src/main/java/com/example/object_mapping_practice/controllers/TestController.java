package com.example.object_mapping_practice.controllers;

import com.example.object_mapping_practice.dtos.combined.CombinedResponseDto;
import com.example.object_mapping_practice.dtos.service1.UserAccDetailsDto;
import com.example.object_mapping_practice.dtos.service2.OrderDetailsDto;
import com.example.object_mapping_practice.mappers.CombinedResponseMapper;
import com.example.object_mapping_practice.services.OutboundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.ObjectMapper;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class TestController {

    @Autowired
    private RestTemplate template;

    @Autowired
    CombinedResponseMapper combinedResponseMapper;

    @Autowired
    OutboundService service;


    @GetMapping("/test")
    public ResponseEntity<CombinedResponseDto> test(){
        ResponseEntity<UserAccDetailsDto> userAccDetailsDtoResponseEntity = template.exchange("http://localhost:8080/getUserAccDetails", HttpMethod.GET, null, UserAccDetailsDto.class);
        System.out.println(userAccDetailsDtoResponseEntity);

        ResponseEntity<OrderDetailsDto> orderDetailsDtoResponseEntity = template.exchange("http://localhost:8080/getOrderDetails", HttpMethod.GET, null, OrderDetailsDto.class);
        System.out.println(orderDetailsDtoResponseEntity);

        var transformedRes = combinedResponseMapper.toDto(userAccDetailsDtoResponseEntity.getBody(), orderDetailsDtoResponseEntity.getBody());
        return ResponseEntity.ok(transformedRes);


    }

    @GetMapping("/test2")
    public ResponseEntity<OrderDetailsDto> test2(){
        ResponseEntity<OrderDetailsDto> orderDetailsDtoResponseEntity = template.exchange("http://localhost:8080/getOrderDetails", HttpMethod.GET, null, OrderDetailsDto.class);
        System.out.println(orderDetailsDtoResponseEntity);
        return ResponseEntity.ok(orderDetailsDtoResponseEntity.getBody());
    }

    @GetMapping("/parallelCall")
    public ResponseEntity<CombinedResponseDto> parallelCall()  {
        CompletableFuture<UserAccDetailsDto> serviceCall1 = CompletableFuture.supplyAsync(
                () -> {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
//                    System.out.println(10/0);
                    System.out.println("1nd task got completed");

                    return template.exchange("http://localhost:8080/getUserAccDetails", HttpMethod.GET, null, UserAccDetailsDto.class).getBody();
                }
        );

        CompletableFuture<OrderDetailsDto> serviceCall2 = CompletableFuture.supplyAsync(
                ()-> {
                    try {
                        Thread.sleep(8000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("2nd task got completed");
                   return template.exchange("http://localhost:8080/getOrderDetails", HttpMethod.GET, null, OrderDetailsDto.class).getBody();
                }
        );

       /* CompletableFuture.allOf(serviceCall1.exceptionally(ex -> new UserAccDetailsDto()), serviceCall2);

        try {
//            var service1Response = serviceCall1.exceptionally(ex -> null).get();
//            var service1Response = serviceCall1.exceptionally(ex -> new UserAccDetailsDto()).get();
            var service1Response = serviceCall1.get();
            var service2Response = serviceCall2.exceptionally(ex -> new OrderDetailsDto()).get();
            System.out.println(service1Response);
            System.out.println(service2Response);
            return  ResponseEntity.ok(combinedResponseMapper.toDto(service1Response, service2Response));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            System.out.println("Exception in outbound call");
            return ResponseEntity.badRequest().body(new CombinedResponseDto());
        }*/
        return ResponseEntity.ok(new CombinedResponseDto());
    }

    @GetMapping("/placeOrder")
    public String placeOrder(){
        System.out.println("order placed sending an email");
        service.sendEmail();
        return "Order placed successfully, you will receive an Email shortly";
    }


}
