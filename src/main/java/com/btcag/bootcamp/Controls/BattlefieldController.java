package com.btcag.bootcamp.Controls;

import com.btcag.bootcamp.Models.Battlefield;
import com.btcag.bootcamp.Models.Robot;
import com.btcag.bootcamp.Views.BattlefieldView;

import java.util.Arrays;

public class BattlefieldController {

	public static Battlefield battlefield = new Battlefield(15,10);

	//Fühle Array mit Leeren Felder '[ ]' aus
	public static void createClearBattlefield (String[][] newBattlefield) {
		for (String[] strings : newBattlefield) {
			Arrays.fill(strings, "[ ]");
		}
		Battlefield.setBattlefieldArray(newBattlefield);
	}

	//Updates Battlefield on users interface
	public static void manageBattlefield() {
		String[][] battlefieldArray = Battlefield.getBattlefieldArray();


		BattlefieldController.createClearBattlefield(battlefieldArray);
		RobotController.setNewRobotPositions(Robot.getRobotList());
		BattlefieldView.displayBattlefield();
	}

	public static boolean invalidMove(int x, int y) {
		String[][] battlefieldArray = Battlefield.getBattlefieldArray();
		return x < 0 || x >= Battlefield.getWidth()
				|| y < 0 || y >= Battlefield.getHeight()
				|| !battlefieldArray[y][x].equals("[ ]");
	}

}
