package com.btcag.bootcamp;

public class Game {

    public static boolean gameOver = true;
    public static boolean playersTurn = true;

    //Checks if player wins the game
    static void checkWinConditionPlayer(Character player, Character opponent) {
        if (player.getPositionX() == opponent.getPositionX() && player.getPositionY() == opponent.getPositionY()) {
            System.out.println("Endlich! Du hasst " + opponent.getName() + " gewonnen.");
            gameOver = false;
        }
    }

    //Checks if opponent wins the game
    static void checkWinConditionAI(Character player, Character opponent) {
        if (opponent.getPositionX() == player.getPositionX() && opponent.getPositionY() == player.getPositionY()) {
            System.out.println("Leider dein Gegner " + opponent.getName() + " war stärker... für dieses mal");
            gameOver = false;
        }
    }
}
