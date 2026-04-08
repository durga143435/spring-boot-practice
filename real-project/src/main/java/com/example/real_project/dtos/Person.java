package com.example.real_project.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person<T> {
    T person;

    public T getPerson(){
        return  person;
    }

}
