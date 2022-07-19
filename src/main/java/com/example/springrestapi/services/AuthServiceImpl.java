package com.example.springrestapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.springrestapi.entities.User;
import com.example.springrestapi.models.UserDto;
import com.example.springrestapi.requestBodies.Auth.AuthRequest;
import com.example.springrestapi.services.interfaces.AuthService;
import com.example.springrestapi.services.interfaces.UserService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public String login(AuthRequest request) throws Exception {

        return "";
    }

    @Override
    @Transactional
    public UserDto registerUser(UserDto user) throws Exception {

        User existedUser = userService.getUserByEmail(user.getEmail());
        if (existedUser != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "User with email: " + user.getEmail() + " already existed");
        }

        userService.addNewUser(user);

        return user;
    }

}
