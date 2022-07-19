package com.example.DemoSpringBoot.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.DemoSpringBoot.entities.Users;
import com.example.DemoSpringBoot.models.DTO.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO user2DTO(Users user);

    List<UserDTO> users2DTOs(List<Users> users);

    @InheritInverseConfiguration
    Users DTO2User(UserDTO userDTO);

    
}
