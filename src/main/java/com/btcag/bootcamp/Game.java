package com.btcag.bootcamp;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    public static boolean gameOver = true;
    public static int playerCounter;

    // Increases Player Robot Attributes for every Win
    public static void increaseAttributes(Scanner scanner, int playerIndex, ArrayList<Robot> robotList){
        boolean done = false;
        while (!done) {
            System.out.println("Welche Attributen wollen Sie erhöhen");
            int input;
            try {
                input = Integer.parseInt(scanner.nextLine());

                switch (input) {
                    case 1 -> {} // increaseHP();
                    case 2 -> {} // increaseEP();
                    case 3 -> {} // increaseMS();
                    case 4 -> {} // increaseAS();
                    case 5 -> {} // increaseDM();
                    case 6 -> {} // increaseAB();
                    case 7 -> {done = true;}
                    default -> System.out.println("Ungültige Eingabe. Bitte wählen Sie eine Zahl zwischen 1 und 7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
            }
        }
    }

    //Checks if player wins the game
    static void checkWinConditionPlayer(int currentPlayerIndex, ArrayList<Robot> robotList) {
        Robot currentPlayer = robotList.get(currentPlayerIndex);
        for (int j = 0; j < robotList.size(); j++) {
            if (j == currentPlayerIndex) continue;
            Robot otherPlayer = robotList.get(j);

            if (currentPlayer.getPositionX() == otherPlayer.getPositionX() && currentPlayer.getPositionY() == otherPlayer.getPositionY()) {
                System.out.println("Spieler " + currentPlayer.getName() + " trifft Spieler " + robotList.get(j).getName() + " und gewinnt!");
                gameOver = false; // Setzt das Spiel auf beendet
            }
        }
    }

    //Checks if opponent wins the game
    static void checkWinConditionAI(Robot player, Robot opponent) {
        if (opponent.getPositionX() == player.getPositionX() && opponent.getPositionY() == player.getPositionY()) {
            System.out.println("Leider dein Gegner " + opponent.getName() + " war stärker... für dieses mal");
            gameOver = false;
        }
    }
}
