package com.btcag.bootcamp.Controls;

import com.btcag.bootcamp.Enums.Colors;
import com.btcag.bootcamp.Models.AI;
import com.btcag.bootcamp.Models.Battlefield;
import com.btcag.bootcamp.Models.Player;
import com.btcag.bootcamp.Models.Robot;
import com.btcag.bootcamp.Views.GameView;
import com.btcag.bootcamp.Views.OtherView;
import com.btcag.bootcamp.Views.RobotView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.btcag.bootcamp.Models.Game.getRandom;
import static com.btcag.bootcamp.Services.InputService.userInputInt;
import static java.lang.Math.ceil;

public class RobotController {

	public static void createRobot () {
		PlayerController.askPlayersNumber();
		IntStream.range(0, Player.getPlayerCounter()).forEach(i -> {
			Robot.getRobotList().add(new Robot(RobotView.displayAskRobotName(i)));
			Robot.getRobotList().get(i).generateXYPosition(Battlefield.getBattlefieldArray());
			increaseAttributes(i, (ArrayList<Robot>) Robot.getRobotList());
		});
		AIController.askAICounter();
		IntStream.range(0, AI.getAiCounter()).forEach(_ -> {
			Robot.getRobotList().add(new Robot(getRandom().nextInt(1000)));
			int index = Robot.getRobotListSize() - 1;
			Robot.getRobotList().get(index).generateXYPosition(Battlefield.getBattlefieldArray());
		});
	}

	public static Colors chooseColor(){
		boolean validInput = false;
		while (!validInput) {
			int input;
			try {
				input = RobotView.displayAskRobotColor();
				switch (input) {
					case 1 -> {validInput = true; return Colors.BLACK;  } // Setzt Farbe auf Schwarz
					case 2 -> {validInput = true; return Colors.RED;}     // Setzt Farbe auf Rot
					case 3 -> {validInput = true; return Colors.GREEN; }  // Setzt Farbe auf Grün
					case 4 -> {validInput = true; return Colors.YELLOW; } // Setzt Farbe auf Gelb
					case 5 -> {validInput = true; return Colors.BLUE; }   // Setzt Farbe auf Blau
					case 6 -> {validInput = true; return Colors.PURPLE; } // Setzt Farbe auf Lila
					case 7 -> {validInput = true; return Colors.CYAN; }   // Setzt Farbe auf Cyan
					default -> System.out.println("Ungültige Eingabe. Bitte wählen Sie eine Zahl zwischen 1 und 7.");
				}
			} catch (NumberFormatException e) {
				OtherView.displayInvalidInputInt();
			}
		}
		return null;
	}

	public static List<Robot> getValidTargetList (Robot currRobot) {
		List<Robot> targetList = new ArrayList<>(Robot.getRobotList());
		//Player Roboter aus der Liste löschen, wenn identisch ist
		targetList.removeIf(target -> target.equals(currRobot) || !isInRange(currRobot, target));
		return targetList;
	}

	private static boolean isInRange(Robot currRobot, Robot target) {
		//Ausrechnen, ob Target is in Range von currRoboter
		double distance = Math.sqrt(
				Math.pow(target.getPositionX() - currRobot.getPositionX(), 2) +
						Math.pow(target.getPositionY() - currRobot.getPositionY(), 2)
		);
		return distance <= currRobot.getAR();
	}

	public static void attackTarget (Robot attacker, Robot target) {
		GameView.displayAttackMessage(attacker, target);
		int damageOutcome = (int) ceil(attacker.getBD() - target.getAS()); //ToDo:  * attacker.getDM() in Zukunft hinzufügen
		target.setHP(target.getHP()-damageOutcome);
		GameView.displayAttackResultMessage(attacker,target,damageOutcome);
		isRobotDefeated(target);
	}

	private static void isRobotDefeated(Robot target) {
		if (target.getHP() <= 0 ){
			RobotView.displayDefeatStatus(target.getName());
			List<Robot> robotList = Robot.getRobotList();
			robotList.removeIf(defeatedRobot -> defeatedRobot.equals(target.getName()));
		}
	}

	// Increases Player Robot Attributes at generation and for every Win
	public static void increaseAttributes(int playerIndex, ArrayList<Robot> robotList){
		boolean done = false;
		Robot robot = robotList.get(playerIndex);
		do {
			RobotView.displayIncreaseAttributes(robot);
			try {
				int input = RobotView.displayAskIncreaseAttributes();
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
							System.out.println("Ungültige Eingabe. Bitte wählen Sie eine Zahl zwischen 1 und 9.");
				}
			} catch (NumberFormatException e) {
				OtherView.displayInvalidInputInt();
			}
		} while (!done);
	}

	public static void increaseAttribute(Robot robot, String attributeName, double costMultiplier, double baseCost, double increaseValue) {
		// Dynamisch den aktuellen Attributwert ermitteln
		double currentValue;
		switch (attributeName) {
			case "HP" :
				currentValue = robot.getHP();
				break;
			case "EP":
				currentValue = robot.getEP();
				break;
			case "AR":
				currentValue = robot.getAR();
				break;
			case "BD":
				currentValue = robot.getBD();
				break;
			case "MS":
				currentValue = robot.getMS();
				break;
			case "AS":
				currentValue = robot.getAS();
				break;
			case "DM":
				currentValue = robot.getDM();
				break;
			case "AB":
				currentValue = robot.getAB();
				break;
			default:
				System.out.println("Unbekanntes Attribut: " + attributeName);
				return;
		}

		// Kosten berechnen
		int cost = (int) Math.ceil(currentValue * costMultiplier + baseCost);

		// Überprüfen, ob genügend AP vorhanden sind
		if (cost > robot.getAP()) {
			RobotView.displayNotEnoughAP(cost, robot.getAP());
			return;
		}

		try {
			// AP anpassen
			robot.setAP(robot.getAP() - cost);

			// Attribut erhöhen
			switch (attributeName) {
				case "HP":
					robot.setHP((int) (currentValue + increaseValue));
					break;
				case "EP":
					robot.setEP((int) (currentValue + increaseValue));
					break;
				case "AR":
					robot.setAR((int) (currentValue + increaseValue));
					break;
				case "BD":
					robot.setBD((int) (currentValue + increaseValue));
					break;
				case "MS":
					robot.setMS((int) (currentValue + increaseValue));
					break;
				case "AS":
					robot.setAS((int) (currentValue + increaseValue));
					break;
				case "DM":
					robot.setDM((float) (currentValue + increaseValue));
					break;
				case "AB":
					robot.setAB((float) (currentValue + increaseValue));
					break;
			}

			// Erfolgsnachricht anzeigen
			RobotView.displayIncreaseAttributesSuccess(attributeName,increaseValue,currentValue + increaseValue,cost);

		} catch (NumberFormatException e) {
			OtherView.displayInvalidInputInt();
		}
	}

	//Erhöht Health Points
	public static void increaseHP(Robot robot) {
		increaseAttribute(robot, "HP", 1.0 / 8.0, 0, 3);
	}

	// Erhöht Energy Points
	public static void increaseEP(Robot robot) {
		increaseAttribute(robot, "EP", 1.0 / 3.0, 0, 2);
	}

	// Erhöht Attack Range
	public static void increaseAR(Robot robot) {
		increaseAttribute(robot, "AR", 2, 0, 1);
	}

	//Erhöht Base Damage
	public static void increaseBD(Robot robot) {
		increaseAttribute(robot, "BD", 3, 0, 1);
	}

	// Erhöht Movement Speed
	public static void increaseMS(Robot robot) {
		increaseAttribute(robot, "MS", 1.5, 0, 1);
	}

	//Erhöht Armor Score
	public static void increaseAS(Robot robot) {
		increaseAttribute(robot, "AS", 1.7, 2, 1);
	}

	//Erhöht Damage Modifier
	public static void increaseDM(Robot robot) {
		increaseAttribute(robot, "DM", 1.6, 1, 0.15);
	}

	//Erhöht Accuracy Bonus
	public static void increaseAB(Robot robot) {
		increaseAttribute(robot, "AB", 7.5, 2, 0.05);
	}
}
