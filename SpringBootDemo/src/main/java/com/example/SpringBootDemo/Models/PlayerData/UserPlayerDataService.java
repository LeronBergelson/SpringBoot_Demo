package com.example.SpringBootDemo.Models.PlayerData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserPlayerDataService {

    private final static String USER_NOT_FOUND_MESSAGE = "User with email $s not found";

    @Autowired
    PlayerDataRepository playerDataRepository;

    // Enables user once registration is confirmed.
    public int enablePlayer(String email) {
        return playerDataRepository.enablePlayer(email);
    }


    public String createPlayerData(UserPlayerData userPlayerData) {

        playerDataRepository.save(userPlayerData); // Saves player data to the user_player_data table.

        return "Created Player Data for " + userPlayerData.getEmail();
    }

    public String updatePlayer(UserPlayerData userPlayerData) {

        boolean userExists = playerDataRepository.findByEmail(userPlayerData.getEmail()).isPresent(); // Checks if user exists.

        // If user exists then throw exception and don't add new user
        if(!userExists){
            throw new IllegalStateException("User does not exist!");
        }

        playerDataRepository.updatePlayerData(userPlayerData.getEmail(), userPlayerData.getHealth(), userPlayerData.getXcoord(), userPlayerData.getYcoord(),
                                        userPlayerData.getZcoord(), userPlayerData.getBluestageattempts(), userPlayerData.getYellowstageattempts(),
                                        userPlayerData.getRedstageattempts());

        return "Updated: " + userPlayerData.getEmail();
    }

    public UserPlayerData getPlayerData(String playerEmail) {
        Optional<UserPlayerData> userExists = playerDataRepository.findByEmail(playerEmail); // Checks if user exists.

        // If user exists then throw exception and don't add new user
        if(!userExists.isPresent()) {
            throw new IllegalStateException("User does not exist!");
        }

        return userExists.get();
    }
}
