package com.example;

import com.example.dtos.SampleUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class JacksonAnnotationPractice {

    public static void main(String[] args) throws IOException {
        File simpleUserJson = new File(System.getProperty("user.dir")+"/src/main/resources/sampleUser.json");

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        SampleUser user = mapper.readValue(simpleUserJson, SampleUser.class);

        //will ignore salay and password in the serialization
        System.out.println(user);

        SampleUser user2 = new SampleUser("ram krish", 25, "mypass123", "321313");
        System.out.println(user2);

        System.out.println(mapper.writeValueAsString(user2));

    }
}
