package com.btcag.bootcamp.Views;

import com.btcag.bootcamp.Models.Robot;

import java.util.ArrayList;

import static com.btcag.bootcamp.Controls.BattlefieldController.createClearBattlefield;
import static com.btcag.bootcamp.Models.Battlefield.battlefield;
import static com.btcag.bootcamp.Models.Robot.setNewRobotPositions;

public class BattlefieldView {

	//Updates Battlefield on users interface
	public static void displayBattlefield(ArrayList<Robot> robotList) {
		String[][] battlefieldArray = battlefield.getBattlefieldArray();

		createClearBattlefield(battlefieldArray);
		setNewRobotPositions(robotList);

		// Spielfeld auf der Konsole anzeigen
		for (int i = 0; i < battlefield.getHeight(); i++) {
			for (int j = 0; j < battlefield.getWidth(); j++) {
				System.out.print(battlefieldArray[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
