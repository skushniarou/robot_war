package com.btcag.bootcamp.Views;

import com.btcag.bootcamp.Controls.GameController;
import com.btcag.bootcamp.Models.Robot;

import java.util.ArrayList;

import static com.btcag.bootcamp.Models.Robot.robotList;
import static com.btcag.bootcamp.Services.InputService.userInputInt;

public class RobotView {
    public static void display() {
        System.out.println("Liste der Roboter:");
        for (Robot robot : robotList) {
            System.out.println("Name='" + robot.getName() + "', Symbol='" + robot.getNameChar() + "', x=" + robot.getPositionX() + ", y=" + robot.getPositionY() + ", Color=" + robot.getColor() + ", isHuman=" + robot.getIsHuman() + " ");
            System.out.println("HP = " + robot.getHP() + ", EP = " + robot.getEP() + ", AR = " + robot.getAR() + ", BD = " + robot.getBD() + ", MS = " + robot.getMS() + ", AS = " + robot.getAS() + ", Damage Mod. = " + robot.getDM() + ", AC-Bonus = " + robot.getAB());
            System.out.println();
        }
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
                    case 1 -> GameController.increaseHP(robotList.get(playerIndex)); // increaseHP();
                    case 2 -> GameController.increaseEP(robotList.get(playerIndex)); // increaseEP();
                    case 3 -> GameController.increaseMS(robotList.get(playerIndex)); // increaseMS();
                    case 4 -> GameController.increaseAS(robotList.get(playerIndex)); // increaseAS();
                    case 5 -> GameController.increaseDM(robotList.get(playerIndex)); // increaseDM();
                    case 6 -> GameController.increaseAB(robotList.get(playerIndex)); // increaseAB();
                    case 7 -> done = true;
                    default ->
                            System.out.println("Ungültige Eingabe. Bitte wählen Sie eine Zahl zwischen 1 und 7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
            }
        } while (!done);
    }

}
