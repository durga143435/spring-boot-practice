package org.example.dtos.attr;

import lombok.Data;

import java.util.List;

@Data
public class RoutingDto {
    String routingEndpoint;
    String routingType;
    String bearerToken;
    RoutingConfigDto routingConfig;
    List<String> dynamicEmailAddressConfig;
}
