package com.example.DemoSpringBoot.controllerz.publIc;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DemoSpringBoot.models.DTO.UserDTO;
import com.example.DemoSpringBoot.services.UserServiceImpl;

@RestController
@RequestMapping("api/v1/public/userss")
public class UserPublicController {
    @Autowired
    private UserServiceImpl uService;

    @GetMapping(value = "")
    public List<UserDTO> getAllUsers() throws Exception {
        return uService.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    public UserDTO getOneByID(@PathVariable BigInteger id) throws Exception {
        return uService.getOneUser(id);
    }
}
