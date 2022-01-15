package com.example.SpringBootDemo.Models.Authentication;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthenticationRequest {
    private String username;
    private String password;

    AuthenticationRequest(String username, String password){
        this.username = username;
        this.password = password;
    }
}
