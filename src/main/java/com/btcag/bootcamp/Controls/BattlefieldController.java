package com.btcag.bootcamp.Controls;

import com.btcag.bootcamp.Models.Battlefield;

import java.util.Arrays;

import static com.btcag.bootcamp.Models.Battlefield.battlefield;

public class BattlefieldController {

	public static void createClearBattlefield (String[][] newBattlefield) {
		for (String[] strings : newBattlefield) {
			Arrays.fill(strings, "[ ]");
		}
		Battlefield.setBattlefieldArray(newBattlefield);
	}

	public static boolean notValidMove (int x, int y) {
		String[][] battlefieldArray = Battlefield.getBattlefieldArray();
		return x < 0 || x >= Battlefield.getWidth()
				|| y < 0 || y >= Battlefield.getHeight()
				|| !battlefieldArray[y][x].equals("[ ]");
	}

}
