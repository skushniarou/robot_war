package com.btcag.bootcamp.Views;

import static com.btcag.bootcamp.Services.InputService.userInputInt;

public class AIView {
	public static int displayAskAINumber(){
		return userInputInt("Gebe Anzahl von KI-Gegner ein: ");
	}
}
