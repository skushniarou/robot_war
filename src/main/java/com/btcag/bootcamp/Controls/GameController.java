package com.btcag.bootcamp.Controls;

import com.btcag.bootcamp.Robot;
import com.btcag.bootcamp.Views.IntroScreenView;

import java.util.ArrayList;

import static com.btcag.bootcamp.Battlefield.*;
import static com.btcag.bootcamp.Game.*;
import static com.btcag.bootcamp.Mechanics.*;

public class GameController {
    public static void main(String[] args) {
        //Intro
        IntroScreenView.introduction();

        //Spielfeld generieren + eine Spielerliste aus Roboter erstellen
        createGameComponents();

        //Gibt Liste von Spieler aus mit Attributen
        System.out.println("Liste der Roboter:");
        for (Robot robot : robotList) {
            System.out.println("Name='" + robot.getName() + "', Symbol='" + robot.getNameChar() + "', x=" + robot.getPositionX() + ", y=" + robot.getPositionY() + ", Color=" + robot.getColor() + ", isHuman=" + robot.getIsHuman() + " ");
            System.out.println("HP = " + robot.getHP() + ", EP = " + robot.getEP() + ", AR = " + robot.getAR() + ", BD = " + robot.getBD() + ", MS = " + robot.getMS() + ", AS = " + robot.getAS() + ", Damage Mod. = " + robot.getDM() + ", AC-Bonus = " + robot.getAB());
            System.out.println();
        }

        //Game with Turnorder
        displayBattlefield((ArrayList<Robot>) robotList);
        while (isGameOn()) {
            for (int i = 0; i < getRobotListLength(); i++) {
                if (robotList.get(i).getIsHuman()) {
                    playerTurn(robotList.get(i), battlefield);
                } else {
                    aiTurn(robotList.get(i), battlefield);
                }
                checkWinCondition(i,(ArrayList<Robot>) robotList);
            }
        }
    }
}