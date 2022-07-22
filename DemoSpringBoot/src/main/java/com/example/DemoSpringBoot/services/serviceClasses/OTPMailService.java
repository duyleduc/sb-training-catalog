package com.example.DemoSpringBoot.services.serviceClasses;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.DemoSpringBoot.entities.OTPs;
import com.example.DemoSpringBoot.repositories.OTPRepository;
import com.example.DemoSpringBoot.templates.EmailTemplate;

@Service
public class OTPMailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private OTPRepository repository;

    // @Autowired
    // private static DateTimeValidation DTValidation;

    private static final Integer EXPIRE_MINS = 4;
    private static final String SUCCESS = "Entered Otp is valid";
    private static final String FAIL = "Entered Otp is NOT valid. Please Retry!";

    public OTPMailService() {
        super();
    }

    public OTPs generateMailOTP(String receiver) throws Exception {
        Optional<OTPs> DBotp = repository.findByEmail(receiver);
        Random random = new Random();
        int otp = 10000 + random.nextInt(90000);
        OTPs OTP = new OTPs();
        if (DBotp.isPresent()) {
            OTP = DBotp.get();
            OTP.setExpDate(EXPIRE_MINS.intValue());
            OTP.setOTP(otp);
        } else {
            OTP = new OTPs();
            OTP.setEmail(receiver);
            OTP.setExpDate(EXPIRE_MINS.intValue());
            OTP.setOTP(otp);
        }
        return OTP;
    }

    public Optional<OTPs> getEmailOtp(String receiver) {
        try {
            return repository.findByEmail(receiver);
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    public void sendMailOTPUser(String receiver, String fullname, String subject) throws Exception {

        OTPs OTP = generateMailOTP(receiver);

        EmailTemplate template = new EmailTemplate("MailOTP.html");

        Map<String, String> replacements = new HashMap<String, String>();

        replacements.put("user", fullname);
        replacements.put("OTP Number", String.valueOf(OTP.getOTP()));
        replacements.put("Exp", Integer.toString(EXPIRE_MINS));

        String fixedMessage = template.getTemplate(replacements);

        generateAndSendMessage(receiver, subject, fixedMessage, OTP);
    }

    private boolean isBeforeorNow(final Date date) {
        System.out.println(new Date().getTime() +"  "+ date.getTime());
        return new Date().getTime() <= date.getTime();
    }

    public String validateMailOTPUser(int otpnum, String receiver) {
        if (otpnum >= 0) {
            Optional<OTPs> serverOTP = getEmailOtp(receiver);
            if (serverOTP.isPresent()) {
                if (isBeforeorNow(serverOTP.get().getExpDate())) {
                    if (otpnum == serverOTP.get().getOTP()) {
                        System.out.println(";asldkfja;sldkf");
                        return SUCCESS;
                    }
                }
                else{
                    return "OTP is expired";
                }
            }
        }
        return FAIL;
    }

    private void generateAndSendMessage(String receiver, String subject, String message, OTPs OTP)
            throws MessagingException {
        MimeMessage msg = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);

        helper.setTo(receiver);
        helper.setSubject(subject);
        helper.setText(message, true);
        mailSender.send(msg);

        repository.save(OTP);
    }
}
