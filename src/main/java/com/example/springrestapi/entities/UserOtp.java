package com.example.springrestapi.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class UserOtp {
    @Id
    Long id;

}
