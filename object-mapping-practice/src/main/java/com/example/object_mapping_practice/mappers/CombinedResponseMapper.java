package com.example.object_mapping_practice.mappers;


import com.example.object_mapping_practice.dtos.combined.*;
import com.example.object_mapping_practice.dtos.service1.AccountDto;
import com.example.object_mapping_practice.dtos.service1.ProfileDto;
import com.example.object_mapping_practice.dtos.service1.TransactionDto;
import com.example.object_mapping_practice.dtos.service1.UserAccDetailsDto;
import com.example.object_mapping_practice.dtos.service2.ItemDto;
import com.example.object_mapping_practice.dtos.service2.OrderDetailsDto;
import com.example.object_mapping_practice.dtos.service2.TrackingHistoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import javax.crypto.spec.PSource;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Mapper(componentModel = "spring")
public interface CombinedResponseMapper {

    @Mapping(source = "userAccDetailsDto.userName", target = "name")
    @Mapping(source = "userAccDetailsDto.profile", target = "profileInfo")
    @Mapping(source = "userAccDetailsDto.profile.phoneNumber", target = "profileInfo.mobileNumber")
    @Mapping(source = "userAccDetailsDto.profile.address.postalCode", target = "profileInfo.address.pinCode")
    @Mapping(source = "userAccDetailsDto.accounts", target = "accountsInfo")
    @Mapping(source = "userAccDetailsDto.accounts", target = "accountIds")
    @Mapping(source = "orderDetailsDto.isActive", target = "isActive")
    @Mapping(source = "orderDetailsDto.orderDate", target = "orderPlacedDate")
    @Mapping(source = "orderDetailsDto.customer", target = "customerInfo")
    @Mapping(source = "orderDetailsDto.shipment", target = "shipmentData")
    @Mapping(source = "orderDetailsDto.shipment.deliveryAddress", target = "shipmentData.deliveryAddressInfo")
    @Mapping(source = "userAccDetailsDto.accounts", target = "transactionAmounts")

//    @Mapping(target = "customObj.profileName",
//            expression = "java(userAccDetailsDto.getProfile().getFirstName() + \"  \" + userAccDetailsDto.getProfile().getLastName())")
    @Mapping(source = "userAccDetailsDto.profile", target = "customObj.profileName")
    @Mapping(source = "userAccDetailsDto.accounts", target = "customObj.accountName")
    @Mapping(source = "userAccDetailsDto.profile.phoneNumber", target = "customObj.mobile")
    CombinedResponseDto toDto(UserAccDetailsDto userAccDetailsDto, OrderDetailsDto orderDetailsDto);

    @Mapping(source = "balance", target = "amount")
    AccountResponseDto toDto(AccountDto accountDto);


    @Mapping(source = "txnId", target = "txnNum")
    TransactionResponseDto toDto(TransactionDto transactionDto);

    @Mapping(source = "productName", target = "itemName")
    @Mapping(source = "price", target = "amount")
    ItemResponseDto toDto(ItemDto itemDto);

    @Mapping(source = "status", target = "statusInfo")
    TrackingHistoryResponseDto toDto(TrackingHistoryDto trackingHistoryDto);

    default Set<String> map(Set<AccountDto> accounts) {
        if (accounts == null) return Collections.emptySet();

        return accounts.stream()
                .map(AccountDto::getAccountId) // 👈 extract ID
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    default List<List<BigDecimal>> extractTransactionAmounts(Set<AccountDto> accounts){
        if (accounts == null || accounts.isEmpty())
            return Collections.emptyList();

    //after filtering, taking 1st object and proceeding further

//        Optional<List<BigDecimal>> amounts = accounts.stream()
//                .filter(account -> account.getAccountId().equals("A1003"))
//                .findFirst()
//                .map(account -> account.getTransactions().stream()
//                        .map(transaction -> transaction.getAmount())
//                        .collect(Collectors.toList()));
//
//        return amounts.orElse(Collections.emptyList());



        List<List<BigDecimal>> amountList = accounts.stream()
                .filter(account -> account.getAccountId().equals("A1001"))
                .map(account -> account.getTransactions().stream()
                        .map(transaction -> transaction.getAmount())
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

        return amountList;
    }

    default String extractAccountName(Set<AccountDto> accounts){
        if(accounts == null || accounts.isEmpty())
            return "";
        return accounts.stream().skip(1).findFirst().map(account -> account.getAccountName()).get();
    }

    default String mapProfileNameToCustomObjName(ProfileDto profile){
        if (profile.getFirstName() == null)
            return "" ;
        return profile.getFirstName() + " " +profile.getLastName();
    }




    //conditional mapping using if
    //source is arraylis and map to 3rd to source field
    //source data as date type but in target as string

}
