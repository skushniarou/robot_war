package com.btcag.bootcamp.Controls;

import com.btcag.bootcamp.Models.AI;
import com.btcag.bootcamp.Models.Player;
import com.btcag.bootcamp.Models.Robot;
import com.btcag.bootcamp.Views.RobotView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.btcag.bootcamp.Models.AI.setAiCounter;
import static com.btcag.bootcamp.Models.Battlefield.battlefield;
import static com.btcag.bootcamp.Models.Game.getRandom;
import static com.btcag.bootcamp.Models.Robot.*;
import static com.btcag.bootcamp.Services.InputService.userInputInt;
import static com.btcag.bootcamp.Services.InputService.userInputStr;
import static java.lang.Math.ceil;

public class RobotController {

	public static void createRobot (){
		Player.setPlayerCounter(userInputInt("Gebe Anzahl von Spieler ein: "));
		IntStream.range(0, Player.getPlayerCounter()).forEach(i -> {
			String newName = userInputStr("Wie heißt Roboter von Spieler " + (i + 1) + ": ");
			getRobotList().add(new Robot (newName));
			getRobotList().get(i).generateXYPosition(battlefield.getBattlefieldArray());
			RobotView.increaseAttributes(i, (ArrayList<Robot>) robotList);
		});
		setAiCounter(userInputInt("Gebe Anzahl von KI-Gegner ein: "));
		IntStream.range(0, AI.getAiCounter()).forEach(_ -> {
			getRobotList().add(new Robot(getRandom().nextInt(1000)));
			int index = robotList.size() - 1;
			robotList.get(index).generateXYPosition(battlefield.getBattlefieldArray());
		});
	}

	public static List<Robot> getValidTargetList (Robot currRobot){
		List<Robot> targetList = new ArrayList<>(getRobotList());
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

	public static void attackTarget (Robot currRobot, Robot target) {
		System.out.println(currRobot.getName() + " greift " + target.getName() + " an!");
		int damageDone = (int) ceil(currRobot.getBD() - target.getAS()); //ToDo:  * currRobot.getDM() in Zukunft hinzufügen
		target.setHP(target.getHP()-damageDone);
		System.out.println(currRobot.getName() + " hat " + damageDone + " Schaden verursacht!");
		System.out.println(target.getName() + " hat nur " + target.getHP() + " HP übrig!");
		isRobotDefeated(target);
	}

	private static void isRobotDefeated(Robot target){
		if (target.getHP() <= 0 ){
			System.out.println(target.getName() + " ist besiegt und kann nicht mehr kämpfen");
			List<Robot> robotList = getRobotList();
			robotList.removeIf(defeatedRobot -> defeatedRobot.equals(target.getName()));
		}
	}

}
