package com.example.SpringBootDemo.Models.PlayerData;

import com.example.SpringBootDemo.Models.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface PlayerDataRepository extends JpaRepository<UserPlayerData, Long> {

    Optional<UserPlayerData> findByEmail(String email);

    // Query to update the user's enabled value based on email passed in.
    @Transactional
    @Modifying
    @Query("UPDATE UserPlayerData a " +
            "SET a.isvalid = TRUE WHERE a.email = :email")
    int enablePlayer(@Param("email")String email);

    @Transactional
    @Modifying
    //@Query(value = "CALL UpdatePlayerData(:health, :xcoord, :ycoord, :zcoord, :bluestageattempts, :yellowstageattempts, :redstageattempts)", nativeQuery = true)
    @Query(value = "UPDATE user_player_data a " +
                    "SET " +
                    "a.health = :health, a.xcoord = :xcoord, a.ycoord = :ycoord, a.zcoord = :zcoord, a.bluestageattempts = :bluestageattempts, " +
                    "a.yellowstageattempts = :yellowstageattempts, a.redstageattempts = :redstageattempts " +
                    "WHERE " +
                    "a.email = :email"
                    , nativeQuery = true)
    void updatePlayerData(@Param("email")String email, @Param("health")float health, @Param("xcoord")float xcoord, @Param("ycoord")float ycoord,
                    @Param("zcoord")float zcoord, @Param("bluestageattempts")int bluestageattempts,
                    @Param("yellowstageattempts")int yellowstageattempts, @Param("redstageattempts")int redstageattempts);

}
