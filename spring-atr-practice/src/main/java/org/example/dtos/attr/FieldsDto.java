package org.example.dtos.attr;

import lombok.Data;

import java.util.List;

@Data
public class FieldsDto {
    String id;
    String fieldName;
    String fieldType;
    String fieldFormat;
    boolean fieldRequired;
    boolean fieldHidden;
    List<FieldLabelsDto> fieldLabels;
    List<String> fieldDescriptions;
    List<String> fieldValues;
    String validationMapping;
    String formId;
    String fieldPlaceholder;
    AdditionalAttributesDTO additionalAttributes;
}
