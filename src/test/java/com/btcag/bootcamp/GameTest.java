package com.btcag.bootcamp;

import com.btcag.bootcamp.Models.Robot;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static com.btcag.bootcamp.Models.Game.isGameOn;
import static com.btcag.bootcamp.Models.Game.setGameOn;
import static com.btcag.bootcamp.Models.Robot.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class GameTest {

    @BeforeEach
    void setUp() {
        setGameOn(true);
        robotList = new ArrayList<> ();
    }

    @AfterEach
    void tearDown() {
        robotList.clear();
    }

    @Test
    void testCheckWinConditionWithOneRobot() {
        Robot robot = new Robot(1);
        robotList.add(robot);
        // Überprüfe die Sieg-Bedingung
        checkWinCondition(0, (ArrayList<Robot>) robotList);
        assertFalse(isGameOn(), "gameOn sollte auf false gesetzt sein, wenn nur ein Roboter übrig ist.");
    }

    private void checkWinCondition (int i, ArrayList<Robot> robotList) {
    }

    @Test
    void testCheckWinConditionWithMultipleRobots(){
        Robot robot1 = new Robot(1);
        Robot robot2 = new Robot(2);
        robotList.add(robot1);
        robotList.add(robot2);

        // Überprüfe die Sieg-Bedingung
        checkWinCondition(0, (ArrayList<Robot>) robotList);
        assertTrue(isGameOn(),"gameOn sollte auf true bleiben, wenn 2+ Roboter in Spiel sind.");
    }
}