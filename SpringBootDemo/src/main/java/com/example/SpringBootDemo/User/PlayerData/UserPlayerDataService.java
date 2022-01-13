package com.example.SpringBootDemo.User.PlayerData;

import com.example.SpringBootDemo.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPlayerDataService {

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

    public String updateUser(UserPlayerData userPlayerData) {

        boolean userExists = playerDataRepository.findByEmail(userPlayerData.getEmail()).isPresent(); // Checks if user exists.

        // If user exists then throw exception and don't add new user
        if(!userExists){
            throw new IllegalStateException("User does not exist!");
        }

        playerDataRepository.updateUser(userPlayerData.getHealth(), userPlayerData.getXCoord(), userPlayerData.getYCoord(),
                                        userPlayerData.getZCoord(), userPlayerData.getBluestageattempts(), userPlayerData.getYellowstageattempts(),
                                        userPlayerData.getRedstageattempts());

        return "Updated: " + userPlayerData.getEmail();
    }

}
