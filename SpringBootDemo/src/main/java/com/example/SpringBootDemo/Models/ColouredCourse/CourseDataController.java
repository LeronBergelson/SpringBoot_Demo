package com.example.SpringBootDemo.Models.ColouredCourse;

import com.example.SpringBootDemo.Models.PlayerData.UserPlayerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api")
public class CourseDataController {

    @Autowired
    CourseDataService courseDataService;

    @PostMapping(path = "/PostPlayerCourseData")
    public String getPlayerData(@RequestBody ColouredStageData colouredStageData){
        return courseDataService.PostPlayerData(colouredStageData);
    }



}
