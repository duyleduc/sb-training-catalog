package com.example.springrestapi.services.interfaces;

import com.example.springrestapi.models.UserDto;
import com.example.springrestapi.requestBodies.Auth.AuthRequest;

public interface AuthService {
    String login(AuthRequest request) throws Exception;

    UserDto registerUser(UserDto user) throws Exception;

}
