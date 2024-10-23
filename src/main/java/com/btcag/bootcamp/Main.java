package com.btcag.bootcamp;

import java.util.Scanner;

import static com.btcag.bootcamp.Mechanics.enemyMove;
import static com.btcag.bootcamp.Mechanics.playerMove;
import static com.btcag.bootcamp.Other.*;

public class Main {
    public static boolean gameOver = true;
    public static boolean playersTurn = true;

    public static void main(String[] args) {

        //Constructor
        Character player = new Character("Abba", "A", 9, 13);
        Character opponent = new Character("Test", "T", 9, 14);
        Scanner scanner = new Scanner(System.in);

        //Intro
        introduction();

        //Namen setzen von Spieler und Opponent
        getCharactersNames(scanner,player,opponent);
        getCharactersSymbol(player,opponent);

        //Spielfeld generieren
        String[][] spielFeld = new String[10][15];
        for (int i = 0; i < spielFeld.length; i++) {
            for (int j = 0; j < spielFeld[i].length; j++) {
                spielFeld[i][j] = "[ ]";
            }
        }

        //Game turn order
        while (gameOver) {
            updatePlayfield(spielFeld, player, opponent);
            playerTurn(scanner, player);
            checkWinConditionPlayer(player, opponent);
            enemyTurn(opponent);
            checkWinConditionOpponent(player, opponent);
        }
    }

    //Checks if player wins the game
    private static void checkWinConditionPlayer(Character player, Character opponent) {
        if (player.getPositionX() == opponent.getPositionX() && player.getPositionY() == opponent.getPositionY()) {
            System.out.println("Endlich! Du hasst " + opponent.getName() + " gewonnen.");
            gameOver = false;
        }
    }

    //Checks if opponent wins the game
    private static void checkWinConditionOpponent(Character player, Character opponent) {
        if (opponent.getPositionX() == player.getPositionX() && opponent.getPositionY() == player.getPositionY()) {
            System.out.println("Leider dein Gegner " + opponent.getName() + " war stärker... für dieses mal");
            gameOver = false;
        }
    }

    //Opponent decides what to do on his turn
    private static void enemyTurn(Character opponent) {
        enemyMove(opponent);
        playersTurn = true;
    }

    //Spieler wird abgefragt was er machen will
    public static void playerTurn(Scanner scanner, Character player) {
        String choice;
        while (playersTurn) { // ToDo: regex oder turnStatus
            System.out.println();
            System.out.println("""
                    Du hasst folgende Aktionen: Welche willst du auswählen?\s
                    1 = Bewegen
                    2 = Angreifen
                    3 = Warten
                    4 = Aufgeben""");
            choice = scanner.nextLine();
            label:
            if (choice.matches("[1234]+")) {
                switch (choice) {
                    case "1":
                        playerMove(scanner, player);
                        playersTurn = false;
                        break label;
                    case "2":
                        // Angreifen
                        break label;
                    case "3":
                        //Warten
                        playersTurn = false;
                        break label;
                    case "4":
                        gameOver = false;
                        playersTurn = false;
                        System.out.println("Du hasst kein Kraft mehr... Leider in diese Kampf hasst du verloren");
                        break label;
                }
            } else {
                System.out.println("Diese Eingabe ist ungültig, geben Sie bitte neu ein!");
            }
        }
    }

    //Saves first Character of Players/Opponents Name

    //Updates Playfield on users interface
    public static void updatePlayfield(String[][] spielFeld, Character player, Character opponent) {
        System.out.println();
        for (int i = 0; i < spielFeld.length; i++) {
            for (int j = 0; j < spielFeld[i].length; j++) {
                if (i == player.getPositionX() && j == player.getPositionY()) {
                    System.out.print(player.getChar());
                } else if (i == opponent.getPositionX() && j == opponent.getPositionY()) {
                    System.out.print(opponent.getChar());
                } else {
                    System.out.print(spielFeld[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}