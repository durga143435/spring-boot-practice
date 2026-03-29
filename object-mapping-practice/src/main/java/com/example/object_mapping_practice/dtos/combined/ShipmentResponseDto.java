package com.example.object_mapping_practice.dtos.combined;

import com.example.object_mapping_practice.dtos.service2.DeliveryAddressDto;
import com.example.object_mapping_practice.dtos.service2.TrackingHistoryDto;
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
