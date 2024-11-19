package com.btcag.bootcamp.Models;

public class AI {
	private static int aiCounter = 0;

	public static int getAiCounter() {
		return aiCounter;
	}

	public static void setAiCounter (int aiCounter) {
		AI.aiCounter = aiCounter;
	}
}
