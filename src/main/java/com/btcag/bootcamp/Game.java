package com.btcag.bootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.btcag.bootcamp.Battlefield.*;
import static com.btcag.bootcamp.Other.*;

public class Game {

    public static boolean gameOver = true;
    private static int playerCounter;
    public static List<Robot> robotList = new ArrayList<>();
    private static int aiCounter;

    public static boolean isGameOver() {
        return gameOver;
    }

    public static int getPlayerCounter() {
        return playerCounter;
    }

    public static int getAiCounter() {
        return aiCounter;
    }

    public static int getRobotListLength(){
        return robotList.size();
    }

    public static void setGameOver(boolean gameOver) {
        Game.gameOver = gameOver;
    }

    public static void setPlayerCounter(int playerCounter) {
        Game.playerCounter = playerCounter;
    }

    public static void setAiCounter(int aiCounter) {
        Game.aiCounter = aiCounter;
    }

    public static void createRobot (){
        setPlayerCounter(userInputInt("Gebe Anzahl von Spieler ein: "));
        IntStream.range(0, getPlayerCounter()).forEach(i -> {
            String newName = userInputStr("Wie heißt Roboter von Spieler " + (i + 1) + ": ");
            robotList.add(new Robot(newName));
            robotList.get(i).generateXYPosition(battlefield.getBattlefieldArray());
            increaseAttributes(i, (ArrayList<Robot>) robotList);
        });
        setAiCounter(userInputInt("Gebe Anzahl von KI-Gegner ein: "));
        IntStream.range(0, getAiCounter()).forEach(_ -> {
            robotList.add(new Robot());
            int index = robotList.size() - 1;
            robotList.get(index).generateXYPosition(battlefield.getBattlefieldArray());
        });
    }

    // Increases Player Robot Attributes at generation and for every Win
    public static void increaseAttributes(int playerIndex, ArrayList<Robot> robotList){
        boolean done = false;
        do {
            System.out.println();
            System.out.println("Dein Roboter hat folgende Attribute:");
            System.out.println("HP = " + robotList.get(playerIndex).getHP() + ", EP = " + robotList.get(playerIndex).getEP() + ", MS = " + robotList.get(playerIndex).getMS() + ", AS = " + robotList.get(playerIndex).getAS() + ", Damage Mod. = " + robotList.get(playerIndex).getDM() + ", Acc. Bonus = " + robotList.get(playerIndex).getAB());
            System.out.println("Du hasst " + robotList.get(playerIndex).getAP() + " Attributes Punkten noch übrig");

            int input;
            try {
                input = userInputInt("Welche Attributen willst du erhöhen?\n1 - HP, 2 - EP, 3 - MS, 4 - AS, 5 - DM, 6 - AB, 7 - Fertig");
                switch (input) {
                    case 1 -> increaseHP(robotList.get(playerIndex)); // increaseHP();
                    case 2 -> increaseEP(robotList.get(playerIndex)); // increaseEP();
                    case 3 -> increaseMS(robotList.get(playerIndex)); // increaseMS();
                    case 4 -> increaseAS(robotList.get(playerIndex)); // increaseAS();
                    case 5 -> increaseDM(robotList.get(playerIndex)); // increaseDM();
                    case 6 -> increaseAB(robotList.get(playerIndex)); // increaseAB();
                    case 7 -> done = true;
                    default ->
                            System.out.println("Ungültige Eingabe. Bitte wählen Sie eine Zahl zwischen 1 und 7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
            }
        } while (!done);
    }

    static void increaseHP(Robot robot) {
        int cost = (int) (double) (robot.getHP() / 8);
        if (cost > robot.getAP()){
            System.out.println("Sie haben nicht genug Attributes Punkte um HP zu erhöhen. Sie brauchen " + cost + " AP, aber haben nur " + robot.getAP());
        } else
            try {
                robot.setAP(robot.getAP() - cost);
                robot.setHP(robot.getHP() + 3);
            System.out.println("Du hasst HP um 3 erhöht. Dein HP ist jetzt " + robot.getHP() + ". Es hat dir " + cost + " Attribut Punkte gekostet");
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
            }
    }

    static void increaseEP(Robot robot) {
        int cost = (int) (double) (robot.getEP() / 3);
        if (cost > robot.getAP()){
            System.out.println("Sie haben nicht genug Attributes Punkte um HP zu erhöhen. Sie brauchen " + cost + " AP, aber haben nur " + robot.getAP());
        } else
            try {
                robot.setAP(robot.getAP() - cost);
                robot.setEP(robot.getEP() + 2);
                System.out.println("Du hasst EP um 2 erhöht. Dein EP ist jetzt " + robot.getEP() + ". Es hat dir " + cost + " Attribut Punkte gekostet");
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
            }
    }

    static void increaseMS(Robot robot) {
        int cost = (int) Math.ceil(robot.getMS() * 1.5);
        if (cost > robot.getAP()){
            System.out.println("Sie haben nicht genug Attributes Punkte um HP zu erhöhen. Sie brauchen " + cost + " AP, aber haben nur " + robot.getAP());
        } else
            try {
                robot.setAP(robot.getAP() - cost);
                robot.setMS(robot.getMS() + 1);
                System.out.println("Du hasst MS um 1 erhöht. Dein MS ist jetzt " + robot.getMS() + ". Es hat dir " + cost + " Attribut Punkte gekostet");
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
            }
    }

    static void increaseAS(Robot robot) {
        int cost = (int) Math.ceil((robot.getAS() * 1.7)+2);
        if (cost > robot.getAP()){
            System.out.println("Sie haben nicht genug Attributes Punkte um HP zu erhöhen. Sie brauchen " + cost + " AP, aber haben nur " + robot.getAP());
        } else
            try {
                robot.setAP(robot.getAP() - cost);
                robot.setAS(robot.getAS() + 1);
                System.out.println("Du hasst AS um 1 erhöht. Dein AS ist jetzt " + robot.getAS() + ". Es hat dir " + cost + " Attribut Punkte gekostet");
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
            }
    }

    static void increaseDM(Robot robot) {
        int cost = (int) Math.ceil((robot.getDM() * 1.6)+1);
        if (cost > robot.getAP()){
            System.out.println("Sie haben nicht genug Attributes Punkte um HP zu erhöhen. Sie brauchen " + cost + " AP, aber haben nur " + robot.getAP());
        } else
            try {
                robot.setAP(robot.getAP() - cost);
                robot.setDM((float) (robot.getDM() + 0.15));
                System.out.println("Du hasst DM um 15% erhöht. Dein DM ist jetzt " + robot.getDM() + ". Es hat dir " + cost + " Attribut Punkte gekostet");
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
            }
    }

    static void increaseAB(Robot robot) {
        int cost = (int) Math.ceil((robot.getAB() * 7.5)+2);
        if (cost > robot.getAP()){
            System.out.println("Sie haben nicht genug Attributes Punkte um HP zu erhöhen. Sie brauchen " + cost + " AP, aber haben nur " + robot.getAP());
        } else
            try {
                robot.setAP(robot.getAP() - cost);
                robot.setAB((float) (robot.getAB() + 0.05));
                System.out.println("Du hasst AB um 5% erhöht. Deine AB ist jetzt " + robot.getAB() + ". Es hat dir " + cost + " Attribut Punkte gekostet");
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
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
