package com.example.object_mapping_practice.dtos.service2;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Set;

@Data
public class ShipmentDto {
    @JsonProperty("shipment_id")
    private String shipmentId;

    @JsonProperty("delivery_address")
    private DeliveryAddressDto deliveryAddress;

    @JsonProperty("tracking_history")
    private Set<TrackingHistoryDto> trackingHistory;

}
