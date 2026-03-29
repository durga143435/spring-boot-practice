package com.example.object_mapping_practice.dtos.combined;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionResponseDto {

    private String txnNum;

    @JsonProperty("txn_date")
    private String txnDate;

}
