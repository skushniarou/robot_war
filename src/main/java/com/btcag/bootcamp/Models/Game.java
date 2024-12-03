package com.btcag.bootcamp.Models;

import java.util.Random;

public class Game {

	static Random random = new Random();
	private static boolean gameOn = true;

	public static Random getRandom() {
		return random;
	}

	public static boolean isGameOn() {
		return gameOn;
	}

	public static void setGameOn (boolean gameOn) {
		Game.gameOn = gameOn;
	}

}
