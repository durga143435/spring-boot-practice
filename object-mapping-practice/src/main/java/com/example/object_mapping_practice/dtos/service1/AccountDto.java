package com.example.object_mapping_practice.dtos.service1;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class AccountDto {
    @JsonProperty("account_id")
    private String accountId;

    @JsonProperty("account_name")
    private String accountName;
    private BigDecimal balance;
    private String currency;
    private Set<TransactionDto> transactions;


}
