package com.btcag.bootcamp;

import java.util.ArrayList;
import java.util.Scanner;

import static com.btcag.bootcamp.Battlefield.*;
import static com.btcag.bootcamp.Game.*;
import static com.btcag.bootcamp.Mechanics.*;
import static com.btcag.bootcamp.Other.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Spielfeld generieren
        createBattlefield();

        //Intro
        introduction();

        // Erstellt eine Liste aus Spieler
        createRobot();

        //Gibt Liste von Spieler aus mit Attributen
        System.out.println("Liste der Roboter:");
        for (Robot robot : robotList) {
            System.out.println("Name='" + robot.getName() + "', Symbol='" + robot.getNameChar() + "', x=" + robot.getPositionX() + ", y=" + robot.getPositionY() + ", Color=" + robot.getColor() + ", isHuman=" + robot.getIsHuman() + " ");
            System.out.println("HP = " + robot.getHP() + ", EP = " + robot.getEP() + ", AR = " + robot.getAR() + ", BD = " + robot.getBD() + ", MS = " + robot.getMS() + ", AS = " + robot.getAS() + ", Damage Mod. = " + robot.getDM() + ", AC-Bonus = " + robot.getAB());
            System.out.println();
        }

        //Game with Turnorder
        updateBattlefield((ArrayList<Robot>) robotList);
        while (gameOver) {
            for (int i = 0; i < getRobotListLength(); i++){
                if (robotList.get(i).getIsHuman() == true) {
                    playerTurn(scanner, robotList.get(i), battlefield);
                    //checkWinConditionPlayer(i,(ArrayList<Robot>) robotList);
                    if (!gameOver) break;
                } else {
                    aiTurn(robotList.get(i), battlefield);
                }
            }
        }
    }
}