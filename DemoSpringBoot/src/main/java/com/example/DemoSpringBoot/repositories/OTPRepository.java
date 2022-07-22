package com.example.DemoSpringBoot.repositories;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.DemoSpringBoot.entities.OTPs;

@Repository
public interface OTPRepository extends JpaRepository<OTPs, BigInteger> {
    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM OTPs otp WHERE otp.email = :email")
    boolean isOTPwithEmail(@Param("email") String receiver);

    Optional<OTPs> findByEmail(String receiver);
}
