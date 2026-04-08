package org.example.dtos.attr;

import lombok.Data;

@Data
public class RoutingConfigDto {
    String emailCC;
    String emailSubject;
    String emailBody;
    String emailAddress;
    String emailLanguage;
    String emailCountry;
    String emailTemplateRouting;
}
