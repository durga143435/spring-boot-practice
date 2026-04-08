package com.example.dtos.service1;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionDto {

    @JsonProperty("txn_id")
    private String txnId;

    private BigDecimal amount;

    @JsonProperty("txn_type")
    private String txnType;

    @JsonProperty("txn_date")
    private String txnDate;

}
