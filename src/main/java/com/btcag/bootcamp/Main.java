package com.btcag.bootcamp;

import java.util.ArrayList;
import java.util.Scanner;

import static com.btcag.bootcamp.Battlefield.*;
import static com.btcag.bootcamp.Game.*;
import static com.btcag.bootcamp.Mechanics.*;
import static com.btcag.bootcamp.Other.*;
import static com.btcag.bootcamp.Robot.createRobot;
import static com.btcag.bootcamp.Robot.robotList;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Spielfeld generieren
        Battlefield battlefield = new Battlefield(10,15);
        createBattlefield(battlefield);

        //Intro
        introduction();

        // Erstellt eine Liste aus Spieler
        createRobot(scanner,battlefield);

        //Gibt Liste von Spieler aus mit Attributen
        System.out.println("Liste der Roboter:");
        for (Robot robot : robotList) {
            System.out.println("Name='" + robot.getName() + "', Symbol='" + robot.getNameChar() + "', x=" + robot.getPositionX() + ", y=" + robot.getPositionY() + ", Color=" + robot.getColor() + ", isHuman=" + robot.getIsHuman() + " ");
            System.out.println("HP = " + robot.getHP() + ", EP = " + robot.getEP() + ", MS = " + robot.getMS() + ", AS = " + robot.getAS() + ", Damage Mod. = " + robot.getDM() + ", AC-Bonus = " + robot.getAB());
            System.out.println();
        }

        //Game with Turnorder
        while (gameOver) {
            for (int i = 0; i < playerCounter; i++){
                updateBattlefield(battlefield, (ArrayList<Robot>) robotList);
                playerTurn(scanner,robotList.get(i),battlefield);
                checkWinConditionPlayer(i,(ArrayList<Robot>) robotList);
                if (!gameOver) break;
            }
        }
    }
}