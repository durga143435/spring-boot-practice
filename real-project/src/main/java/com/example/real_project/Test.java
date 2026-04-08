package com.example.real_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestTemplate;

public class Test {

    @Autowired
    @Qualifier("")
    private RestTemplate template;
    private String[] names = {"name1","name2"};

    private int[] numbers = {5,10,3,9};

    public static void main(String[] args) {
        Test t = new Test();
        for(String name: t.names){
            System.out.println(name);
        }

        for(int num: t.numbers){
            System.out.println(num);
        }
    }
}
