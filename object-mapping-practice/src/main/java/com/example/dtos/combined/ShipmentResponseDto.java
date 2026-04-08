package com.example.dtos.combined;

import com.example.dtos.service2.DeliveryAddressDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Set;

@Data
public class ShipmentResponseDto {
    @JsonProperty("shipment_id")
    private String shipmentId;

    private DeliveryAddressDto deliveryAddressInfo;

    @JsonProperty("tracking_history")
    private Set<TrackingHistoryResponseDto> trackingHistory;

}
