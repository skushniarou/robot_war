package com.btcag.bootcamp.Views;

import com.btcag.bootcamp.Controls.GameController;
import com.btcag.bootcamp.Controls.RobotController;
import com.btcag.bootcamp.Enums.Attributes;
import com.btcag.bootcamp.Models.Robot;

import java.util.ArrayList;

import static com.btcag.bootcamp.Models.Robot.robotList;
import static com.btcag.bootcamp.Services.InputService.userInputInt;

public class RobotView {
    public static void displayRobotList () {
        System.out.println("Liste der Roboter:");
        for (Robot robot : Robot.getRobotList()) {
            System.out.println("Name='" + robot.getName() + "', Symbol='" + robot.getNameChar() + "', x=" + robot.getPositionX() + ", y=" + robot.getPositionY() + ", Color=" + robot.getColor() + ", isHuman=" + robot.getIsHuman() + " ");
            displayRobotAttributes(robot);
            System.out.println();
        }
    }

    public static void displayRobotAttributes(Robot robot){
        System.out.println(
            Attributes.HP.getShortForm() + " = " + robot.getHP() +
            ", " + Attributes.EP.getShortForm() + " = " + robot.getEP() +
            ", " + Attributes.AR.getShortForm() + " = " + robot.getAR() +
            ", " + Attributes.BD.getShortForm() + " = " + robot.getBD() +
            ", " + Attributes.MS.getShortForm() + " = " + robot.getMS() +
            ", " + Attributes.AS.getShortForm() + " = " + robot.getAS() +
            ", " + Attributes.DM.getLongForm() + " = " + robot.getDM() +
            ", " + Attributes.AB.getLongForm() + " = " + robot.getAB());
    }

    public static void displayRobotAttributesPoints(Robot robot){
        System.out.println("Du hasst " + robot.getAP() + " Attributes Punkten noch übrig");
    }

    // Increases Player Robot Attributes at generation and for every Win
    public static void increaseAttributes(int playerIndex, ArrayList<Robot> robotList){
        boolean done = false;
        Robot robot = robotList.get(playerIndex);
        do {
            System.out.println();
            System.out.println("Dein Roboter hat folgende Attribute:");
            displayRobotAttributes(robot);
            displayRobotAttributesPoints(robot);
            int input;
            try {
                input = userInputInt("Welche Attributen willst du erhöhen?\n1 - HP, 2 - EP, 3 - AR, 4 - BD, 5 - MS, 6 - AS, 7 - DM, 8 - AB, 9 - Fertig");
                switch (input) {
                    case 1 -> RobotController.increaseHP(robot); // Erhöht Health Points
                    case 2 -> RobotController.increaseEP(robot); // Erhöht Energy Points
                    case 3 -> RobotController.increaseAR(robot); // Erhöht Attack Range
                    case 4 -> RobotController.increaseBD(robot); // Erhöht Base Damage
                    case 5 -> RobotController.increaseMS(robot); // Erhöht Movement Speed
                    case 6 -> RobotController.increaseAS(robot); // Erhöht Armor Score
                    case 7 -> RobotController.increaseDM(robot); // Erhöht Damage Modifier
                    case 8 -> RobotController.increaseAB(robot); // Erhöht Accuracy Bonus
                    case 9 -> done = true;
                    default ->
                            System.out.println("Ungültige Eingabe. Bitte wählen Sie eine Zahl zwischen 1 und 7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
            }
        } while (!done);
    }

    public static void displayDefeatStatus(String name){
        System.out.println(name + " ist besiegt und kann nicht mehr kämpfen");
    }

    public static void displayRobotXYPosition(Robot robot){
        System.out.println(robot.getName() + " hat sich nach Position [" + robot.getPositionX() + "," + robot.getPositionY() + "] bewegt.");
        System.out.println();
    }

    public static void displayNotEnoughAP(int cost, int ap){
        System.out.println("Sie haben nicht genug Attributes Punkte um HP zu erhöhen. Sie brauchen " + cost + " AP, aber haben nur " + ap);
    }
}
