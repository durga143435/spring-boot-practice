package com.example.dtos.combined;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TransactionResponseDto {

    private String txnNum;

    @JsonProperty("txn_date")
    private String txnDate;

}
