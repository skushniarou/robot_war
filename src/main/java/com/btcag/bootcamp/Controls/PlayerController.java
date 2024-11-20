package com.btcag.bootcamp.Controls;

import com.btcag.bootcamp.Models.Player;
import com.btcag.bootcamp.Views.PlayerView;

public class PlayerController {

	public static void askPlayersNumber(){
		Player.setPlayerCounter(PlayerView.askPlayerNumber());
	}
}
