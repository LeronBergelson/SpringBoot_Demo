package com.example.SpringBootDemo.User.PlayerData;

import com.example.SpringBootDemo.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api")
public class PlayerDataRestController {

    @Autowired
    UserPlayerDataService userPlayerDataService;

    @PutMapping(path = "/updatePlayerData")
    public String updatePlayerData(@RequestBody UserPlayerData userPlayerData){
        return userPlayerDataService.updateUser(userPlayerData);
    }
}


    /*
    @PutMapping(path = "/update/{email}")
    public String updatePerson(@PathVariable("email") String email, @RequestBody User user){
        return userService.updateUser(email, user);
    }
     */