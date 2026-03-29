package com.example.object_mapping_practice.dtos.service2;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class SpecsDto {
    private String brand;
    private String ram;
    private String storage;
    private String type;
}
