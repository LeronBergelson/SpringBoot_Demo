package com.example.SpringBootDemo.Registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.regex.Pattern;

@Service
public class EmailValidator implements Predicate<String> {

    @Override
    public boolean test(String email) {

        boolean result = false;
        String emailRegex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

        if(email != null || !email.isEmpty()){ // Checks to see if the email address string passed in is empty.

            Pattern pattern = Pattern.compile(emailRegex);

            if(pattern.matcher(email).matches()){ // Returns True if the email address is valid.
                result = true; // Sets result to true;
            }
        }

        return result;
    }
}
