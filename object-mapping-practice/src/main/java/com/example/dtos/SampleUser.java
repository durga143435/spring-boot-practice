package com.example.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"password", "salary"})
@JsonPropertyOrder({"age", "name"})
@JsonRootName("mySampleUser")
public class SampleUser {
    String name;
    int age;
    String password;
    String salary;
}
