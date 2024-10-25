package com.btcag.bootcamp;

import java.util.Scanner;

import static com.btcag.bootcamp.Battlefield.*;
import static com.btcag.bootcamp.Game.*;
import static com.btcag.bootcamp.Mechanics.*;
import static com.btcag.bootcamp.Other.*;

public class Main {

    public static void main(String[] args) {

        //Constructor
        Robot player = new Robot("Abba", "A", 9, 13, Colors.BLACK, true);
        Robot opponent = new Robot("Test", "T", 9, 14,Colors.BLACK, false);
        Battlefield battlefield = new Battlefield(10,15);
        Scanner scanner = new Scanner(System.in);

        //Intro
        introduction();

        //Namen setzen von Spieler und Opponent
        getRobotName(scanner,player,opponent);

        //Namen farbig machen
        player.setColor(scanner);
        opponent.setColor(scanner);

        //Erster Buchstabe von Objektname als Symbol benutzen
        player.setNameChar(player.getName());
        opponent.setNameChar(opponent.getName());

        //Spielfeld generieren
        createBattlefield(battlefield);

        //Game turn order
        while (gameOver) {
            updateBattlefield(battlefield, player, opponent);
            playerTurn(scanner, player, battlefield);
            checkWinConditionPlayer(player, opponent);
            aiTurn(opponent,battlefield);
            checkWinConditionAI(player, opponent);
        }
    }
}