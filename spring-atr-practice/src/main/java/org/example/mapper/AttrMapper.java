package org.example.mapper;

import org.example.dtos.attr.GetAttrResponseDto;
import org.example.dtos.attr.UpdateAttrRequestDto;
import org.example.dtos.attr.UpdateAttrResponseDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AttrMapper {
    UpdateAttrResponseDto toDto(GetAttrResponseDto request);

//    @BeanMapping()
//    UpdateAttrResponseDto toDtos(GetAttrResponseDto request, UpdateAttrResponseDto response);
}
