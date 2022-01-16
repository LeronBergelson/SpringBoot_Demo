package com.example.SpringBootDemo.Models.ColouredCourse;

import com.example.SpringBootDemo.Models.PlayerData.UserPlayerData;
import com.example.SpringBootDemo.Models.User.User;
import com.example.SpringBootDemo.Models.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseDataService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CourseDataRepository courseDataRepository;

    public String PostPlayerData(ColouredStageData colouredStageData) {

        Optional<User> user = userRepository.findByEmail(colouredStageData.getEmail()); // Checks if user exists.

        // If user exists then throw exception and don't add new user
        if(!user.isPresent()) {
            throw new IllegalStateException("User does not exist!");
        }

        courseDataRepository.save(new ColouredStageData(colouredStageData.getEmail(), colouredStageData.getBluestagecompletiontime(),
                                                        colouredStageData.getYellowstagecompletiontime(), colouredStageData.getRedstagecompletiontime(), user.get()));

        return "Player info added!";
    }
}
