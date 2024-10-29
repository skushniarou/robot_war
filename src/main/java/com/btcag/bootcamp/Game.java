package com.btcag.bootcamp;

import java.util.ArrayList;

public class Game {

    public static boolean gameOver = true;
    public static int playerCounter;

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
