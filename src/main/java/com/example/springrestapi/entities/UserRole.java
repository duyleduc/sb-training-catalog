package com.example.springrestapi.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import com.example.springrestapi.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserRole {

    @Id
    @GeneratedValue
    Long id;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToMany
    private List<User> user;

    public UserRole(Role role) {
        this.role = role;
    }
}
