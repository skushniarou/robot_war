package com.btcag.bootcamp.Views;

import com.btcag.bootcamp.Enums.Attributes;
import com.btcag.bootcamp.Models.Robot;

import static com.btcag.bootcamp.Services.InputService.userInputInt;
import static com.btcag.bootcamp.Services.InputService.userInputStr;

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

    public static String displayAskRobotName (int index){
        return userInputStr("Wie heißt Roboter von Spieler " + (index + 1) + ": ");
    }

    public static int displayAskRobotColor(){
        return userInputInt("Wähle bitte Farbe von deinem Roboter? 1 - BLACK, 2 - RED, 3 - GREEN, 4 - YELLOW, 5 - BLUE, 6 - PURPLE, 7 - CYAN: ");
    }

    public static void displayRobotAttributesPoints(Robot robot){
        System.out.println("Du hasst " + robot.getAP() + " Attributes Punkten noch übrig");
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

    public static void displayIncreaseAttributes(Robot robot){
        System.out.println();
        System.out.println("Dein Roboter hat folgende Attribute:");
        RobotView.displayRobotAttributes(robot);
        RobotView.displayRobotAttributesPoints(robot);
    }

    public static int displayAskIncreaseAttributes(){
	    return userInputInt("Welche Attributen willst du erhöhen?\n" +
	            "1 - " + Attributes.HP.getShortForm() +
	            ", 2 - " + Attributes.EP.getShortForm() +
	            ", 3 - " + Attributes.AR.getShortForm() +
	            ", 4 - " + Attributes.BD.getShortForm() +
	            ", 5 - " + Attributes.MS.getShortForm() +
	            ", 6 - " + Attributes.AS.getShortForm() +
	            ", 7 - " + Attributes.DM.getShortForm() +
	            ", 8 - " + Attributes.AB.getShortForm() +
	            ", 9 - Fertig");
    }

    public static void displayIncreaseAttributesSuccess(String attributeName, double increaseValue, double newValue, int cost){
        System.out.printf("Du hast %s um %.2f Punkte erhöht. Dein %s ist jetzt %.2f Es hat dir %d Attributpunkte gekostet.%n",
                attributeName, increaseValue, attributeName, newValue, cost);

    }
}
