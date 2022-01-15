package com.example.SpringBootDemo.Models.User;

import com.example.SpringBootDemo.Models.PlayerData.UserPlayerData;
import com.example.SpringBootDemo.Models.PlayerData.UserPlayerDataService;
import com.example.SpringBootDemo.Registration.Token.ConfirmationToken;
import com.example.SpringBootDemo.Registration.Token.ConfirmationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
//@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MESSAGE = "User with email $s not found";
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    ConfirmationTokenService confirmationTokenService;
    @Autowired
    UserPlayerDataService userPlayerDataService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MESSAGE, email)));
    }

    // Enables user once registration is confirmed.
    public int enableUser(String email) {
        return userRepository.enableUser(email);
    }


    public String signUpUser(User user) {
        boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent(); // Checks if user exists.

        // If user exists then throw exception and don't add new user
        if(userExists){
            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword()); // Encrypts user password

        user.setPassword(encodedPassword); // Updates password.

        userRepository.save(user); // Saves user to the User table.

        userPlayerDataService.createPlayerData(new UserPlayerData(user.getEmail(), user));

        String token = UUID.randomUUID().toString(); // Confirmation token is created.
        ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(), LocalDateTime.now().plusMinutes(30), user); // ConfirmationToken object is declared.
        confirmationTokenService.saveConfirmationToken(confirmationToken); // ConfirmationToken object is added to the Confirmation_Token Table.

        return token;
    }


}
