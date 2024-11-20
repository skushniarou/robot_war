package com.btcag.bootcamp.Views;

import com.btcag.bootcamp.Models.Robot;

import java.util.List;

import static com.btcag.bootcamp.Services.InputService.userInputInt;
import static com.btcag.bootcamp.Services.InputService.userInputStr;

public class PlayerView {

	public static int askPlayerNumber(){
		return userInputInt("Gebe Anzahl von Spieler ein: ");
	}

	public static String askPlayerTurn(String name){
		return userInputStr(
			"Du hast folgende Aktionen " + name + ":\n" +
				"1 = Bewegen\n" +
				"2 = Angreifen\n" +
				"3 = Warten\n" +
				"4 = Aufgeben\n" +
				"Welche willst du auswählen?\n");
	}

	public static String askPlayerTurnMove(){
		return userInputStr("""
                    In welche Richtung möchtest du dich bewegen?\s
                    w = oben
                    a = links
                    s = unten
                    d = rechts
                    e = Bewegung beenden""");
	}

	public static int askPlayerTargetNumber(){
		return userInputInt("Wer sollte angegriffen werden? (Gebe nummer ein):");
	}

	public static void displayPlayerInvalidMoveMessage(){
		System.out.println("Du kannst nicht weiter Bewegen.\nWähle eine andere Richtung.");
	}

	public static void displayPlayerValidTargetList(List<Robot> validTargetList){
		System.out.println("Diese Roboter sind in deinem Attack Range:");
		for (int i = 0; i < validTargetList.size(); i++) {
			System.out.println((i + 1) + ") " + validTargetList.get(i).getName());
		}
	}

	public static void displayPlayerNoTargetInRange(){
		System.out.println("Niemand ist in deinem Attack Range.");
	}
}
