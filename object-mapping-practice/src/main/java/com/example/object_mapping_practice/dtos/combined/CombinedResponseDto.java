package com.example.object_mapping_practice.dtos.combined;

import com.example.object_mapping_practice.dtos.service1.AccountDto;
import com.example.object_mapping_practice.dtos.service1.ProfileDto;
import com.example.object_mapping_practice.dtos.service2.CustomerDto;
import com.example.object_mapping_practice.dtos.service2.ItemDto;
import com.example.object_mapping_practice.dtos.service2.ShipmentDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
public class CombinedResponseDto {
    private String userId;

    @JsonProperty("custom_user_name")
    private String name;
    private Boolean isActive;
    private ProfileResponseDto profileInfo;
    private Set<AccountResponseDto> accountsInfo;

    private Integer orderId;

    private LocalDate orderPlacedDate;

    private CustomerResponseDto customerInfo;

    @JsonProperty("order_status")
    private String orderStatus;

    private Set<ItemResponseDto> items;
    private ShipmentResponseDto shipmentData;
    private String prop1;
    private String prop2;

    @JsonProperty("custom_Obj")
    private CustomObj customObj;

    private Set<String> accountIds;

    private List<List<BigDecimal>> transactionAmounts;

}

