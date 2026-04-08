package com.example.real_project;

import com.example.real_project.dtos.Account;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties("person")
@Data
public class AppConfiguration {
//    Map<String, String> account;
    Map account;
//    Account account;
    Map<String, String> address;
}
