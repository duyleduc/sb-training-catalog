package com.example.DemoSpringBoot.templates;

public class OTPRequestBodyTemplate {
    private String receiver, fullname, subject;

    public OTPRequestBodyTemplate() {
    }

    public OTPRequestBodyTemplate(String receiver, String fullname, String subject) {
        this.receiver = receiver;
        this.fullname = fullname;
        this.subject = subject;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}