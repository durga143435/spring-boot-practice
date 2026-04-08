package org.example.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class ConsumedMsgDto {
    private UUID traceId;
    private String message;
}
