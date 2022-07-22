package com.example.DemoSpringBoot.models.DTO;

public class ValidateOTP {
    private String email;
    private int OTP;

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

    public ValidateOTP() {
    }

    public ValidateOTP(String email, int otp) {
        this.email = email;
        OTP = otp;
    }

    

}
