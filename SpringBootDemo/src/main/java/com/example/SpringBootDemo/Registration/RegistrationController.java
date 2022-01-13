package com.example.SpringBootDemo.Registration;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api")
//@AllArgsConstructor
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;


    @GetMapping(path = "/")
    public String home(){
        return("<h1>Welcome</h1>");
    }


    @PostMapping(path = "/registration")
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

    @GetMapping(path = "/registration/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

}
