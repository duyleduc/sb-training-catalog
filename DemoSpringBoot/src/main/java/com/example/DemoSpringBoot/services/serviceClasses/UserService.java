package com.example.DemoSpringBoot.services.serviceClasses;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.DemoSpringBoot.entities.Users;
import com.example.DemoSpringBoot.mappers.UserMapper;
import com.example.DemoSpringBoot.models.DTO.UserDTO;
import com.example.DemoSpringBoot.repositories.UserRepository;
import com.example.DemoSpringBoot.services.UserServiceImpl;

@Service
public class UserService implements UserServiceImpl {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserRepository repository;

    // @Autowired
    // private JavaMailSender mailSender;

    // @Autowired
    // private OTPService otpService;

    @Value("${spring.mail.username}")
    private String sender;

    @Override
    public UserDTO postUser(UserDTO userDTO) throws Exception {
        try {
            Users newUser = repository.save(mapper.DTO2User(userDTO));
            return mapper.user2DTO(newUser);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<UserDTO> getAllUsers() throws Exception {

        try {
            List<Users> users = repository.findAll();
            return mapper.users2DTOs(users);
        } catch (Exception exception) {
            throw exception;
        }
    }

    @Override
    public UserDTO getOneUser(BigInteger id) throws Exception {
        try {
            Optional<Users> user = repository.findById(id);
            return mapper.user2DTO(user.get());
        } catch (Exception exception) {
            throw exception;
        }
    }

    @Override
    public UserDTO editUser(UserDTO editInfo, BigInteger id) throws Exception {
        try {
            Users user = repository.findById(id).get();

            user.setFirstName(editInfo.getFirstName());
            user.setLastName(editInfo.getLastName());
            user.setEmail(editInfo.getEmail());
            user.setPhone(editInfo.getPhone());

            repository.save(user);

            return mapper.user2DTO(user);
        } catch (Exception exception) {
            throw exception;
        }
    }

    // @Override
    // public void sendOTPUser(String receiver, String fullname, String subject, String message) throws Exception {
    //     int otp = otpService.generateOTP(receiver).get(0);
    //     int expiremins = otpService.generateOTP(receiver).get(1);

    //     EmailTemplate template = new EmailTemplate("MailOTP.html");

    //     Map<String, String> replacements = new HashMap<String, String>();

    //     replacements.put("user", fullname);
    //     replacements.put("OTP Number", String.valueOf(otp));
    //     replacements.put("Exp", String.valueOf(expiremins));

    //     String fixedMessage = template.getTemplate(replacements);

    //    generateAndSendMessage(receiver, subject, fixedMessage);
    // }

    // private void generateAndSendMessage(String receiver, String subject, String message) throws MessagingException {
    //     MimeMessage msg = mailSender.createMimeMessage();
    //     MimeMessageHelper helper = new MimeMessageHelper(msg, true);

    //     helper.setTo(receiver);
    //     helper.setSubject(subject);
    //     helper.setText(message, true);
    //     mailSender.send(msg);
    // }
}
