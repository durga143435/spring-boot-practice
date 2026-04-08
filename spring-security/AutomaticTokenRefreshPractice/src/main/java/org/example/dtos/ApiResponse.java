package org.example.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
    private int status;
    private String errorMessage;
    private String payload;

    public static ApiResponse error(int status, String errorMessage){
        return new ApiResponse(status, errorMessage,null);
    }
}
