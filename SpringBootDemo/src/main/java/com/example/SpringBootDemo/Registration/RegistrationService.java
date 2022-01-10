package com.example.SpringBootDemo.Registration;

import com.example.SpringBootDemo.Models.User;
import com.example.SpringBootDemo.Services.UserService;
import com.example.SpringBootDemo.UserRoles.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final EmailValidator emailValidator;
    private final UserService userService;


    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());

        if(!isValidEmail){
            throw new IllegalStateException(("Email not valid"));
        }

        return userService.signUpUser(new User(request.getFirstName(), request.getLastName(), request.getEmail(), request.getPassword(), UserRole.USER));
    }




}
