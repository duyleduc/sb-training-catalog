package com.example.springrestapi.requestBodies;

import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Auth {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AuthRequest {
        @Email
        private String email;
        private String phone;
    }

}
