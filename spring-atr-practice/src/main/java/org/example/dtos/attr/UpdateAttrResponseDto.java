package org.example.dtos.attr;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class UpdateAttrResponseDto {
    String id;
    String applicationId;
    String formName;
    List<String> displayName;
    String marketCode;
    LocalDateTime createdDate;
    LocalDateTime modifiedDate;
    List<FieldsDto> fields = new ArrayList<>();
    AdditionalAttributesDTO additionalAttributes;
    RoutingDto routing;
    String createdDateFormatted;
    String modifiedDateFormatted;
}
