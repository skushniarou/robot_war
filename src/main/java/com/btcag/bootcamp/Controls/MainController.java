package com.btcag.bootcamp.Controls;

import com.btcag.bootcamp.Models.Battlefield;
import com.btcag.bootcamp.Models.Game;
import com.btcag.bootcamp.Models.Robot;
import com.btcag.bootcamp.Views.BattlefieldView;
import com.btcag.bootcamp.Views.GameView;
import com.btcag.bootcamp.Views.PlayerView;
import com.btcag.bootcamp.Views.RobotView;

import java.util.ArrayList;

public class MainController {

	public static void main(String[] args) {
		//Intro
		GameView.introduction();

		//Spielfeld generieren + eine Spielerliste aus Roboter erstellen
		GameController.createGameComponents();

		//Gibt Liste von Spieler aus mit Attributen
		RobotView.displayRobotList();

		//Game with Turnorder
		BattlefieldView.displayBattlefield((ArrayList<Robot>) Robot.getRobotList());
		while (Game.isGameOn()) {
			for (int i = 0; i < Robot.getRobotListSize(); i++) {
				if (Robot.getRobotList().get(i).getIsHuman()) {
					PlayerView.playerTurn(Robot.getRobotList().get(i), Battlefield.getBattlefield());
				} else {
					AIController.aiTurn(Robot.getRobotList().get(i));
				}
				GameController.checkWinCondition(i,(ArrayList<Robot>) Robot.getRobotList());
			}
		}
	}
}