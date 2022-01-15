package com.example.SpringBootDemo.Models.PlayerData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api")
public class PlayerDataRestController {

    @Autowired
    UserPlayerDataService userPlayerDataService;

    @GetMapping(path = "/getPlayerData/{playerEmail}")
    public UserPlayerData getPlayerData(@PathVariable("playerEmail") String playerEmail){
        return userPlayerDataService.getPlayerData(playerEmail);
    }

    @PutMapping(path = "/updatePlayerData")
    public String updatePlayerData(@RequestBody UserPlayerData userPlayerData){
        return userPlayerDataService.updatePlayer(userPlayerData);
    }
}