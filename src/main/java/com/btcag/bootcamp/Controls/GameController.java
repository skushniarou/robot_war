package com.btcag.bootcamp.Controls;

import com.btcag.bootcamp.Models.Game;
import com.btcag.bootcamp.Models.Robot;

import java.util.ArrayList;

import static com.btcag.bootcamp.Models.Battlefield.battlefield;

public class GameController {

	public static void createGameComponents (){
		String[][] newBattlefield = new String[battlefield.getHeight()][battlefield.getWidth()];
		BattlefieldController.createClearBattlefield(newBattlefield);
		RobotController.createRobot();
	}

	public static void increaseHP (Robot robot) {
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

	public static void increaseEP (Robot robot) {
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

	public static void increaseMS (Robot robot) {
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

	public static void increaseAS (Robot robot) {
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

	public static void increaseDM (Robot robot) {
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

	public static void increaseAB (Robot robot) {
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

	//Checks if only One Robot is in the game left -> he wins the game
	public static void checkWinCondition (int robotIndex, ArrayList<Robot> robotList) {
		if (robotList.size() == 1) {
			System.out.println("Robot " + robotList.get(robotIndex) + " ist der letzte Roboter!");
			System.out.println("Robot " + robotList.get(robotIndex) + " hat gewonnen!");
			Game.setGameOn(false); // Setzt das Spiel auf beendet
		}
	}
}
