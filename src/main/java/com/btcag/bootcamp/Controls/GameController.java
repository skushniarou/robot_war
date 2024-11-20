package com.btcag.bootcamp.Controls;

import com.btcag.bootcamp.Models.Game;
import com.btcag.bootcamp.Models.Robot;
import com.btcag.bootcamp.Views.GameView;

import java.util.ArrayList;

public class GameController {

	public static void createGameComponents (){
		String[][] newBattlefield = new String[BattlefieldController.battlefield.getHeight()][BattlefieldController.battlefield.getWidth()];
		BattlefieldController.createClearBattlefield(newBattlefield);
		RobotController.createRobot();
	}

	//Checks if only One Robot is in the game left -> he wins the game
	public static void checkWinCondition (int robotIndex, ArrayList<Robot> robotList) {
		if (robotList.size() == 1) {
			GameView.displayWinner(robotList.get(robotIndex).getName());
			Game.setGameOn(false); // Setzt das Spiel auf beendet
		}
	}
}
