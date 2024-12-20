package com.btcag.bootcamp.Controls;

import com.btcag.bootcamp.Models.Game;
import com.btcag.bootcamp.Models.Robot;
import com.btcag.bootcamp.Views.GameView;
import com.btcag.bootcamp.Views.RobotView;

public class MainController {

	public static void main(String[] args) {
		//Intro
		GameView.introduction();

		//Spielfeld generieren + eine Spielerliste aus Roboter erstellen
		GameController.createGameComponents();

		//Gibt Liste von Spieler aus mit Attributen
		RobotView.displayRobotList();

		//Game with Turnorder
		BattlefieldController.manageBattlefield();
		while (Game.isGameOn()) {
			for (int i = 0; i < Robot.getRobotListSize(); i++) {
				if (Robot.getRobotList().get(i).getIsHuman()) {
					PlayerController.playerTurn(Robot.getRobotList().get(i));
				} else {
					AIController.aiTurn(Robot.getRobotList().get(i));
				}
				GameController.checkWinCondition(i, Robot.getRobotList());
			}
		}
	}
}