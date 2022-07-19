package com.example.springrestapi.services.interfaces;

import java.util.UUID;

import com.example.springrestapi.models.UserDto;

public interface UserService {
    UserDto registerUser(UserDto user) throws Exception;

    UserDto editUser(UserDto user, UUID id) throws Exception;

}
