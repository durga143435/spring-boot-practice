package com.example.dtos.combined;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class AccountResponseDto {
    @JsonProperty("account_id")
    private String accountId;

    @JsonProperty("account_name")
    private String accountName;
    private BigDecimal amount;
    private Set<TransactionResponseDto> transactions;

}
