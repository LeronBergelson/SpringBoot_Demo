package com.example.SpringBootDemo.Models.ColouredCourse;

import com.example.SpringBootDemo.Models.User.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class ColouredStageData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email = "";
    private int bluestagecompletiontime = 0;
    private int yellowstagecompletiontime = 0;
    private int redstagecompletiontime = 0;

    @ManyToOne
    @JoinColumn(nullable = false, name = "player_id")
    private User user;

    public ColouredStageData(String email, int blueStageTime, int yellowStageTime, int redStageTime, User user){
        this.email = email;
        this.bluestagecompletiontime = blueStageTime;
        this.yellowstagecompletiontime = yellowStageTime;
        this.redstagecompletiontime = redStageTime;
        this.user = user;
    }
}
