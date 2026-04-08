package org.example.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class MessageDto {
    private UUID traceId = UUID.randomUUID();
    private String message;
}
