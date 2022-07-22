package com.example.DemoSpringBoot.entities;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OTPs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BIGSERIAL NOT NULL")
    private BigInteger ID;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private int OTP;

    @Column
    private Date expDate;

    public OTPs() {
    }

    public OTPs(BigInteger ID, String email, String phone, int oTP, int expiremins) {
        this.ID = ID;
        this.email = email;
        this.phone = phone;
        OTP = oTP;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, expiremins);
        this.expDate = calendar.getTime();
    }

    public BigInteger getID() {
        return ID;
    }

    public void setID(BigInteger iD) {
    ID = iD;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getOTP() {
        return OTP;
    }

    public void setOTP(int oTP) {
        OTP = oTP;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(int expiremins) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, expiremins);
        this.expDate = calendar.getTime();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
