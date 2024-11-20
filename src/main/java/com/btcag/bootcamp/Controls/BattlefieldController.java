package com.btcag.bootcamp.Controls;

import com.btcag.bootcamp.Models.Battlefield;
import com.btcag.bootcamp.Models.Robot;

import java.util.ArrayList;
import java.util.Arrays;

public class BattlefieldController {

	public static Battlefield battlefield = new Battlefield(15,10);

	public static void createClearBattlefield (String[][] newBattlefield) {
		for (String[] strings : newBattlefield) {
			Arrays.fill(strings, "[ ]");
		}
		Battlefield.setBattlefieldArray(newBattlefield);
	}

	// Replace with displayBattlefield
	public static void manageBattlefield(ArrayList<Robot> robotList) {
	}

	public static boolean notValidMove (int x, int y) {
		String[][] battlefieldArray = Battlefield.getBattlefieldArray();
		return x < 0 || x >= Battlefield.getWidth()
				|| y < 0 || y >= Battlefield.getHeight()
				|| !battlefieldArray[y][x].equals("[ ]");
	}

}
