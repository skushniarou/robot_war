package com.btcag.bootcamp.Views;

import com.btcag.bootcamp.Controls.BattlefieldController;
import com.btcag.bootcamp.Controls.RobotController;
import com.btcag.bootcamp.Models.Battlefield;
import com.btcag.bootcamp.Models.Game;
import com.btcag.bootcamp.Models.Robot;

import java.util.ArrayList;
import java.util.List;

import static com.btcag.bootcamp.Controls.RobotController.attackTarget;
import static com.btcag.bootcamp.Controls.RobotController.getValidTargetList;
import static com.btcag.bootcamp.Models.Robot.robotList;
import static com.btcag.bootcamp.Services.InputService.userInputInt;
import static com.btcag.bootcamp.Services.InputService.userInputStr;
import static com.btcag.bootcamp.Views.BattlefieldView.displayBattlefield;

public class PlayerView {

	//Spieler wird abgefragt was er machen will
	public static void playerTurn(Robot player, Battlefield battlefield) {
		String choice = userInputStr(String.format(
				"Du hast folgende Aktionen %s:\nWelche willst du auswählen?\n" +
						"1 = Bewegen\n" +
						"2 = Angreifen\n" +
						"3 = Warten\n" +
						"4 = Aufgeben\n",
				player.getName()));
		label:
		if (choice.matches("[1234]+")) {
			switch (choice) {
				case "1":
					playerMove(player, battlefield);
					playerAttack(player, battlefield);
					break label;
				case "2":
					playerAttack(player, battlefield);
					break label;
				case "3":
					//Warten
					break label;
				case "4":
					System.out.println("Du hasst kein Kraft mehr... Leider in diese Kampf hasst du verloren");
					Game.setGameOn(false);
			}
		} else {
			System.out.println("Diese Eingabe ist ungültig, geben Sie bitte neu ein!");
		}
	}

	//Function to move object on battlefield and check viability of this move
	public static void playerMove(Robot player, Battlefield battlefield) {
		for (int i = 0; i < player.getMS(); i++) {
			boolean check = false;
			while(!check){
				String move = userInputStr("""
                    In welche Richtung möchtest du dich bewegen?\s
                    w = oben
                    a = links
                    s = unten
                    d = rechts
                    e = Bewegung beenden""");
				if (move.matches("[wasdeWASDE]+")){
					switch (move) {
						case "w", "W" -> {
							if (!BattlefieldController.notValidMove(player.getPositionX(), player.getPositionY() - 1)) {
								player.setPositionY(player.getPositionY()-1);
								check = true;
							} else {
								System.out.println("Du kannst nicht weiter Bewegen.\nWähle eine andere Richtung.");
							}
						}
						case "d", "D" -> {
							if (!BattlefieldController.notValidMove(player.getPositionX() + 1, player.getPositionY())) {
								player.setPositionX(player.getPositionX() + 1);
								check = true;
							} else {
								System.out.println("Du kannst nicht weiter Bewegen.\nWähle eine andere Richtung.");
							}
						}
						case "s", "S" -> {
							if (!BattlefieldController.notValidMove(player.getPositionX(), player.getPositionY() + 1)) {
								player.setPositionY(player.getPositionY() + 1);
								check = true;
							} else {
								System.out.println("Du kannst nicht weiter Bewegen.\nWähle eine andere Richtung.");
							}
						}
						case "a", "A" -> {
							if (!BattlefieldController.notValidMove(player.getPositionX() - 1, player.getPositionY())) {
								player.setPositionX(player.getPositionX() - 1);
								check = true;
							} else {
								System.out.println("Du kannst nicht weiter Bewegen.\nWähle eine andere Richtung.");
							}
						}
						case "e", "E" -> {
							i = player.getMS();
							check = true;
						}
						default -> System.out.println("Ungültige Eingabe");
					}
				} else {
					System.out.println("Ungültige Eingabe!");
				}
			}
			displayBattlefield((ArrayList<Robot>) Robot.getRobotList());
			player.displayXYPosition(player);
		}
	}

	public static void playerAttack(Robot player, Battlefield battlefield){
		List<Robot> validTargetList = RobotController.getValidTargetList(player);
		// Display the valid targets with their names and numbers
		int targetIndex;
		if (validTargetList.size() > 0) {
			System.out.println("Diese Roboter sind ind deinem Attack Range:");
			for (int i = 0; i < validTargetList.size(); i++) {
				System.out.println((i + 1) + ") " + validTargetList.get(i).getName());
			}
			//Ask of which opponent must be Attacked
			do {
				targetIndex = userInputInt("Wer sollte angegriffen werden? (Gebe nummer ein):");
				if (targetIndex >= 0 && targetIndex < validTargetList.size() + 1) {
					Robot target = validTargetList.get(targetIndex-1);
					// Proceed with the attack on the selected target
					RobotController.attackTarget(player, target);
				} else {
					System.out.println("Auswahl ist ungültig. Gebe bitte neu ein.");
				}
			} while (targetIndex < 0 || targetIndex >= validTargetList.size() + 1);
		} else {
			System.out.println("Niemand ist in deinem Attack Range.");
		}
	}

}
