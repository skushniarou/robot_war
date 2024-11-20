package com.btcag.bootcamp.Controls;

import com.btcag.bootcamp.Models.AI;
import com.btcag.bootcamp.Models.Battlefield;
import com.btcag.bootcamp.Models.Player;
import com.btcag.bootcamp.Models.Robot;
import com.btcag.bootcamp.Views.GameView;
import com.btcag.bootcamp.Views.RobotView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.btcag.bootcamp.Models.AI.setAiCounter;
import static com.btcag.bootcamp.Models.Game.getRandom;
import static com.btcag.bootcamp.Models.Robot.*;
import static com.btcag.bootcamp.Services.InputService.userInputInt;
import static com.btcag.bootcamp.Services.InputService.userInputStr;
import static java.lang.Math.ceil;

public class RobotController {

	public static void createRobot () {
		Player.setPlayerCounter(userInputInt("Gebe Anzahl von Spieler ein: "));
		IntStream.range(0, Player.getPlayerCounter()).forEach(i -> {
			String newName = userInputStr("Wie heißt Roboter von Spieler " + (i + 1) + ": ");
			Robot.getRobotList().add(new Robot (newName));
			Robot.getRobotList().get(i).generateXYPosition(Battlefield.getBattlefieldArray());
			RobotView.increaseAttributes(i, (ArrayList<Robot>) Robot.getRobotList());
		});
		setAiCounter(userInputInt("Gebe Anzahl von KI-Gegner ein: "));
		IntStream.range(0, AI.getAiCounter()).forEach(_ -> {
			Robot.getRobotList().add(new Robot(getRandom().nextInt(1000)));
			int index = Robot.getRobotListSize() - 1;
			Robot.getRobotList().get(index).generateXYPosition(Battlefield.getBattlefieldArray());
		});
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

}
