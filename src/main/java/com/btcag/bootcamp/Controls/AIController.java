package com.btcag.bootcamp.Controls;

import com.btcag.bootcamp.Models.Battlefield;
import com.btcag.bootcamp.Models.Robot;
import com.btcag.bootcamp.Views.BattlefieldView;
import com.btcag.bootcamp.Views.RobotView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.btcag.bootcamp.Models.Robot.robotList;

public class AIController {

	//AI decides what to do on his turn
	public static void aiTurn (Robot ai, Battlefield battlefield) {
		//Mögliche Moves die KI machen kann
		aiMove(ai,battlefield);
	}

	public static void aiMove(Robot ai, Battlefield battlefield) {
		Random random = new Random();
		for (int i = 0; i < ai.getMS(); i++) {
			List<Integer> availableMoves = getValidMoveIntegersAI(ai, battlefield);
			int randomIndex = random.nextInt(availableMoves.size());
			int randomNumber = availableMoves.get(randomIndex);
			if (randomNumber == 1) {
				ai.setPositionX(ai.getPositionX() - 1);
				RobotView.displayRobotXYPosition(ai);
			} else if (randomNumber == 2) {
				ai.setPositionX(ai.getPositionX() + 1);
				RobotView.displayRobotXYPosition(ai);
			} else if (randomNumber == 3) {
				ai.setPositionY(ai.getPositionY() - 1);
				RobotView.displayRobotXYPosition(ai);
			} else if (randomNumber == 4) {
				ai.setPositionY(ai.getPositionY() + 1);
				RobotView.displayRobotXYPosition(ai);
			}
			BattlefieldView.displayBattlefield((ArrayList<Robot>) Robot.getRobotList());
		}
	}

	private static List<Integer> getValidMoveIntegersAI(Robot ai, Battlefield battlefield) {
		List<Integer> availableMoves = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		// 1 - a - links; 2 - d - rechts; 3 - w - oben; 4 - s - unten
		if ((ai.getPositionY() + 1 > battlefield.getHeight()-1) || BattlefieldController.notValidMove(ai.getPositionX(), ai.getPositionY() + 1)) { // Prüfung auf "s"
			availableMoves.remove((Integer) 4);
		}
		if ((ai.getPositionY() - 1 < 0) || BattlefieldController.notValidMove(ai.getPositionX(), ai.getPositionY() - 1)) { // Prüfung auf "w"
			availableMoves.remove((Integer) 3);
		}
		if ((ai.getPositionX() + 1 > battlefield.getWidth()-1) || BattlefieldController.notValidMove(ai.getPositionX() + 1, ai.getPositionY())) { // Prüfung auf "d"
			availableMoves.remove((Integer) 2);
		}
		if ((ai.getPositionX() - 1 < 0) || BattlefieldController.notValidMove(ai.getPositionX() - 1, ai.getPositionY())) { // Prüfung auf "a"
			availableMoves.remove((Integer) 1);
		}
		return availableMoves;
	}
}
