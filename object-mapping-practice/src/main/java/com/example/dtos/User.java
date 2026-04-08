package com.example.dtos;

import com.example.dtos.service1.AccountDto;
import lombok.Data;


@Data
public class User {
    String name;
    String lastName;
    int age;
    AccountDto account;


}
