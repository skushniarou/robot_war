package com.btcag.bootcamp.Views;

import com.btcag.bootcamp.Models.Battlefield;
import com.btcag.bootcamp.Models.Robot;

import java.util.ArrayList;

import static com.btcag.bootcamp.Controls.BattlefieldController.createClearBattlefield;
import static com.btcag.bootcamp.Models.Robot.setNewRobotPositions;

public class BattlefieldView {

	//Updates Battlefield on users interface
	public static void displayBattlefield(ArrayList<Robot> robotList) {
		String[][] battlefieldArray = Battlefield.getBattlefieldArray();

		createClearBattlefield(battlefieldArray);
		setNewRobotPositions(robotList);

		// Spielfeld auf der Konsole anzeigen
		for (int i = 0; i < Battlefield.getHeight(); i++) {
			for (int j = 0; j < Battlefield.getWidth(); j++) {
				System.out.print(battlefieldArray[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
