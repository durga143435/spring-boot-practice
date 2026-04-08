package com.example.unit_test_practice.mappers;


import com.example.unit_test_practice.dtos.RegisterUserRequest;
import com.example.unit_test_practice.dtos.UpdateUserRequest;
import com.example.unit_test_practice.dtos.UserDto;
import com.example.unit_test_practice.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    User toEntity(RegisterUserRequest request);
    void updateUserEntity(UpdateUserRequest request, @MappingTarget User user);
}
