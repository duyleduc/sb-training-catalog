package com.example.springrestapi.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.springrestapi.entities.User;
import com.example.springrestapi.mappers.UserMapper;
import com.example.springrestapi.models.UserDto;
import com.example.springrestapi.repositories.UserRepository;
import com.example.springrestapi.services.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public UserDto registerUser(UserDto user) throws Exception {

        User existedUser = userRepository.findByEmail(user.getEmail());
        if (existedUser != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "User with email: " + user.getEmail() + " already existed");
        }

        userRepository.save(userMapper.toUser(user));
        return user;
    }

    @Override
    @Transactional
    public UserDto editUser(UserDto user, UUID id) throws Exception {
        Optional<User> existedUser = userRepository.findById(id);
        if (existedUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "User is not existed");
        }
        existedUser.get().setEmail(user.getEmail());
        existedUser.get().setFirstName(user.getFirstName());
        existedUser.get().setLastName(user.getLastName());
        existedUser.get().setPhone(user.getPhone());
        userRepository.save(existedUser.get());
        return user;
    }

}
