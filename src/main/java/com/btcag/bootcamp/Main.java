package com.btcag.bootcamp;

import java.awt.*;
import java.util.Scanner;

import static com.btcag.bootcamp.Battlefield.*;
import static com.btcag.bootcamp.Game.*;
import static com.btcag.bootcamp.Character.*;
import static com.btcag.bootcamp.Mechanics.*;
import static com.btcag.bootcamp.Other.*;

public class Main {

    public static void main(String[] args) {

        //Constructor
        Character player = new Character("Abba", "A", 9, 13, Colors.BLACK);
        Character opponent = new Character("Test", "T", 9, 14,Colors.BLACK);
        Battlefield battlefield = new Battlefield(10,15);
        Scanner scanner = new Scanner(System.in);

        //Intro
        introduction();

        //Namen setzen von Spieler und Opponent
        getCharactersNames(scanner,player,opponent);

        //Name farbig machen
        player.setColor(scanner);
        opponent.setColor(scanner);

        //Erster Buchstabe von Name als Symbol benutzen
        getCharactersSymbol(player,opponent);

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