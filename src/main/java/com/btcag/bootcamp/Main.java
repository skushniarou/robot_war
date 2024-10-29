package com.btcag.bootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.btcag.bootcamp.Battlefield.*;
import static com.btcag.bootcamp.Game.*;
import static com.btcag.bootcamp.Mechanics.*;
import static com.btcag.bootcamp.Other.*;
import static com.btcag.bootcamp.Robot.createRobot;
import static com.btcag.bootcamp.Robot.robotList;

public class Main {

    public static void main(String[] args) {

        //Constructor
        Robot player = new Robot("Abba", "A", 9, 13, Colors.BLACK, true);
        Robot opponent = new Robot("Test", "T", 9, 14,Colors.BLACK, false);
        Battlefield battlefield = new Battlefield(10,15);
        Scanner scanner = new Scanner(System.in);

        //Spielfeld generieren
        createBattlefield(battlefield);

        //Intro
        introduction();

        // Erstellt eine Liste aus Spieler
        createRobot(scanner,battlefield);

        //Gibt Liste von Spieler aus mit Attributen
        System.out.println("Liste der Roboter:");
        for (Robot robot : robotList) {
            System.out.println("Name='" + robot.name + "', Symbol='" + robot.nameChar + "', x=" + robot.currentPositionX + ", y=" + robot.currentPositionY + ", Color=" + robot.color + ", isHuman=" + robot.isHuman + " ");
        }

        //Game with Turnorder
        while (gameOver) {
            for (int i = 0; i < playerCounter; i++){
                //Players turns
            }
            updateBattlefield(battlefield, player, opponent);
            playerTurn(scanner, player, battlefield);
            checkWinConditionPlayer(player, opponent);
            aiTurn(opponent,battlefield);
            checkWinConditionAI(player, opponent);
        }
    }
}