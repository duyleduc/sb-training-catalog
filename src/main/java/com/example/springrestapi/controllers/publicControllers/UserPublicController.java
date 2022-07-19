package com.example.springrestapi.controllers.publicControllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springrestapi.configurations.RequestConfig;
import com.example.springrestapi.models.UserDto;
import com.example.springrestapi.services.interfaces.UserService;

@RestController
@RequestMapping(RequestConfig.BASE_PUBLIC_URL + "/users")
public class UserPublicController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@Valid @RequestBody UserDto body) throws Exception {
        UserDto res = userService.registerUser(body);
        return new ResponseEntity<UserDto>(res, HttpStatus.OK);
    }

}
