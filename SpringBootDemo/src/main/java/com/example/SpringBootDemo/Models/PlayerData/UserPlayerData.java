package com.example.SpringBootDemo.Models.PlayerData;

import com.example.SpringBootDemo.Models.User.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class UserPlayerData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private boolean isvalid = false;
    private float health = 100.0f;
    private float xcoord = 208.425f;
    private float ycoord = 2567.03f;
    private float zcoord = 424.192f;
    private int bluestageattempts = 0;
    private int yellowstageattempts = 0;
    private int redstageattempts = 0;

    @OneToOne
    @JoinColumn(nullable = false, name = "player_id")
    private User user;

    public UserPlayerData(String emailVal, User userVal){
        this.email = emailVal;
        this.user = userVal;
    }

}
