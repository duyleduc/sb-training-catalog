package com.example.DemoSpringBoot.repositories;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DemoSpringBoot.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, BigInteger> {
}
