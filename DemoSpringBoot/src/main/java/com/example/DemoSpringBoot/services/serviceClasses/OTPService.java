package com.example.DemoSpringBoot.services.serviceClasses;

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
public class OTPService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private OTPRepository repository;

    private static final Integer EXPIRE_MINS = 4;
    private static final String SUCCESS = "Entered Otp is valid";
    private static final String FAIL = "Entered Otp is NOT valid. Please Retry!";

    public OTPService() {
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

    public int getOtp(String key) {
        try {
            return 0;
            // TODO:repos
            // return otpCache.get(key);
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public void sendMailOTPUser(String receiver, String fullname, String subject) throws Exception {
        // int otp = generateOTP(receiver);
        // int expiremins = generateOTP(receiver);

        OTPs OTP = generateMailOTP(receiver);

        EmailTemplate template = new EmailTemplate("MailOTP.html");

        Map<String, String> replacements = new HashMap<String, String>();

        replacements.put("user", fullname);
        replacements.put("OTP Number", String.valueOf(OTP.getOTP()));
        replacements.put("Exp", Integer.toString(EXPIRE_MINS));

        String fixedMessage = template.getTemplate(replacements);

        generateAndSendMessage(receiver, subject, fixedMessage, OTP);
    }

    public String validateMailOTPUser(int otpnum, String receiver) {
        if (otpnum >= 0) {
            int serverOTP = getOtp(receiver);
            if (serverOTP > 0) {
                if (otpnum == serverOTP) {
                    // check if expried ?

                    return SUCCESS;
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
