package com.btcag.bootcamp.Views;

import com.btcag.bootcamp.Models.Battlefield;

public class BattlefieldView {

	public static void displayBattlefield() {
		// Spielfeld auf der Konsole anzeigen
		for (int i = 0; i < Battlefield.getHeight(); i++) {
			for (int j = 0; j < Battlefield.getWidth(); j++) {
				System.out.print(Battlefield.getBattlefieldArray()[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
