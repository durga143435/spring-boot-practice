package com.example.real_project.controllers;

import com.example.real_project.AppConfiguration;
import com.example.real_project.dtos.Person;
import com.example.real_project.dtos.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    RestTemplate template;

    @Autowired
    AppConfiguration appConfiguration;

    @GetMapping("/test")
    public String test(){

//        HttpHeaders headers = new HttpHeaders();
//
//        HttpEntity entity = new HttpEntity();
//        template.exchange()
//
//        return  null;

        System.out.println(appConfiguration.getAccount());
        System.out.println(appConfiguration.getAddress());

        return null;
    }

    @GetMapping("/person")
    public ResponseEntity<Person<Student>> getPerson(){
        return  ResponseEntity.ok(new Person<>(new Student("durga", "student", 12, 95)));
    }

    @GetMapping("/test2")
    public  ResponseEntity<Person<Student>> test2(){
       return template.exchange("http://localhost:8080/person", HttpMethod.GET, null, new ParameterizedTypeReference<Person<Student>>() {});
    }

}
