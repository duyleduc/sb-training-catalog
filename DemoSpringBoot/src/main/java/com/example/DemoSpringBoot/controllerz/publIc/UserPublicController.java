package com.example.DemoSpringBoot.controllerz.publIc;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DemoSpringBoot.models.DTO.UserDTO;
import com.example.DemoSpringBoot.models.DTO.ValidateOTP;
import com.example.DemoSpringBoot.services.UserServiceImpl;
import com.example.DemoSpringBoot.services.serviceClasses.OTPMailService;
import com.example.DemoSpringBoot.templates.OTPRequestBodyTemplate;

@RestController
@RequestMapping("api/v1/public/users")
public class UserPublicController {
    @Autowired
    private UserServiceImpl uService;

    @Autowired
    private OTPMailService otpService;

    @GetMapping(value = "")
    public List<UserDTO> getAllUsers() throws Exception {
        return uService.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    public UserDTO getOneByID(@PathVariable BigInteger id) throws Exception {
        return uService.getOneUser(id);
    }

    @PostMapping(value = "/OTP/verify/mail")
    public void sendMailOTPUser(@RequestBody OTPRequestBodyTemplate OTP) throws Exception {
        otpService.sendMailOTPUser(OTP.getReceiver(), OTP.getFullname(), OTP.getSubject());
    }

    @GetMapping(value = "/OTP/validate/mail")
    public String validateMailOTPUser(@RequestBody ValidateOTP validateOTP ) throws Exception {
        return otpService.validateMailOTPUser(validateOTP.getOTP(), validateOTP.getEmail());
    }
}
