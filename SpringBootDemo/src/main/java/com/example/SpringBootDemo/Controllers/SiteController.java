package com.example.SpringBootDemo.Controllers;

import com.example.SpringBootDemo.Registration.RegistrationController;
import com.example.SpringBootDemo.Registration.RegistrationRequest;
import com.example.SpringBootDemo.Registration.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SiteController {

    private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    RegistrationService registrationService;

    @GetMapping(path = "/register")
    public String registrationInfo(Model model){
        model.addAttribute("registerRequest", new RegistrationRequest());
        return "register_page.html";
    }

    @PostMapping(path = "/register")
    public String register(@ModelAttribute RegistrationRequest registerRequest){
        log.info(">> request : {}", registerRequest.toString());
        return registrationService.register(registerRequest);
    }

    @GetMapping(path = "/registration/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
