package com.btcag.bootcamp.Controls;

import com.btcag.bootcamp.Models.Game;
import com.btcag.bootcamp.Models.Player;
import com.btcag.bootcamp.Models.Robot;
import com.btcag.bootcamp.Views.GameView;
import com.btcag.bootcamp.Views.OtherView;
import com.btcag.bootcamp.Views.PlayerView;
import com.btcag.bootcamp.Views.RobotView;

import java.util.List;

public class PlayerController {

	public static void askPlayersNumber(){
		Player.setPlayerCounter(PlayerView.askPlayerNumber());
	}

	//Spieler wird abgefragt was er machen will
	public static void playerTurn(Robot player) {
		String choice = PlayerView.askPlayerTurn(player.getName());
		turn:
		if (choice.matches("[1234]+")) {
			switch (choice) {
				case "1":
					playerMove(player);
					playerAttack(player);
					break turn;
				case "2":
					playerAttack(player);
					break turn;
				case "3":
					//Warten
					break turn;
				case "4":
					GameView.displaySurrender();
					Game.setGameOn(false);
			}
		} else {
			OtherView.displayInvalidInputOverall();
		}
	}

	//Function to move object on battlefield and check viability of this move
	public static void playerMove(Robot player) {
		for (int i = 0; i < player.getMS(); i++) {
			boolean check = false;
			do {
				String move = PlayerView.askPlayerTurnMove();
				if (move.matches("[wasdeWASDE]+")){
					switch (move) {
						case "w", "W" -> {
							if (!BattlefieldController.invalidMove(player.getPositionX(), player.getPositionY() - 1)) {
								player.setPositionY(player.getPositionY()-1);
								check = true;
							} else {
								PlayerView.displayPlayerInvalidMoveMessage();
							}
						}
						case "d", "D" -> {
							if (!BattlefieldController.invalidMove(player.getPositionX() + 1, player.getPositionY())) {
								player.setPositionX(player.getPositionX() + 1);
								check = true;
							} else {
								PlayerView.displayPlayerInvalidMoveMessage();
							}
						}
						case "s", "S" -> {
							if (!BattlefieldController.invalidMove(player.getPositionX(), player.getPositionY() + 1)) {
								player.setPositionY(player.getPositionY() + 1);
								check = true;
							} else {
								PlayerView.displayPlayerInvalidMoveMessage();
							}
						}
						case "a", "A" -> {
							if (!BattlefieldController.invalidMove(player.getPositionX() - 1, player.getPositionY())) {
								player.setPositionX(player.getPositionX() - 1);
								check = true;
							} else {
								PlayerView.displayPlayerInvalidMoveMessage();
							}
						}
						case "e", "E" -> {
							i = player.getMS();
							check = true;
						}
						default -> OtherView.displayInvalidInputOverall();
					}
				} else {
					OtherView.displayInvalidInputOverall();
				}
			} while(!check);
			BattlefieldController.manageBattlefield();
			RobotView.displayRobotXYPosition(player);
		}
	}

	public static void playerAttack(Robot player){
		List<Robot> validTargetList = RobotController.getValidTargetList(player);

		// Display the valid targets with their names and numbers
		if (!validTargetList.isEmpty()) {
			PlayerView.displayPlayerValidTargetList(validTargetList);
			//Ask of which opponent must be Attacked
			int targetIndex;
			do {
				targetIndex = PlayerView.askPlayerTargetNumber();
				if (targetIndex >= 0 && targetIndex < validTargetList.size() + 1) {
					Robot target = validTargetList.get(targetIndex-1);
					// Proceed with the attack on the selected target
					RobotController.attackTarget(player, target);
				} else {
					OtherView.displayInvalidInputChoice();
				}
			} while (targetIndex < 0 || targetIndex >= validTargetList.size() + 1);
		} else {
			PlayerView.displayPlayerNoTargetInRange();
		}
	}
}
