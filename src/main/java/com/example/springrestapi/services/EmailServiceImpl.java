package com.example.springrestapi.services;

import org.springframework.stereotype.Service;

import com.example.springrestapi.parameters.EmailContent;
import com.example.springrestapi.services.interfaces.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

    @Override
    public String sendEmail(EmailContent content) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}
