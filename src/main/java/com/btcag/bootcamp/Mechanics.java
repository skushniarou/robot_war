package com.btcag.bootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Mechanics {

    //Function to move object on battlefield and check viability of this move
    public static void playerMove(Scanner scanner, Character player) {
        String move = "";
        boolean check = false;
        while (!check) {
            System.out.println("""
        In welche Richtung möchtest du dich bewegen?\s
        w = oben
        a = links
        s = unten
        d = rechts""");
        move = scanner.nextLine();

            while(!check){
                if(move.matches("[wasdWASD]+")){
                    if (move.equals("w") || move.equals("W")) {
                        if (player.getPositionX() > 0) {
                            player.currentPositionX -= 1;
                            check = true;
                        } else {
                            System.out.println("Das Spielfeld geht nicht weiter nach oben.\nWähle eine andere Richtung.");
                            move = scanner.nextLine();
                        }
                    } else if (move.equals("d") || move.equals("D")) {
                        if (player.getPositionY() < 14) {
                            player.currentPositionY += 1;
                            check = true;
                        } else {
                            System.out.println("Das Spielfeld geht nicht weiter nach rechts.\nWähle eine andere Richtung.");
                            move = scanner.nextLine();
                        }
                    } else if (move.equals("s") || move.equals("S")) {
                        if (player.getPositionX() < 9) {
                            player.currentPositionX += 1;
                            check = true;
                        } else {
                            System.out.println("Das Spielfeld geht nicht weiter nach unten.\nWähle eine andere Richtung.");
                            move = scanner.nextLine();
                        }
                    } else if (move.equals("a") || move.equals("A")) {
                        if (player.getPositionY() > 0) {
                            player.currentPositionY -= 1;
                            check = true;
                        } else {
                            System.out.println("Das Spielfeld geht nicht weiter nach links.\nWähle eine andere Richtung.");
                            move = scanner.nextLine();
                        }
                    }
                } else {
                    System.out.println("Falsche Eingabe!");
                    break;
                }
            }
        }
    }

    public static void enemyMove(Character opponent) {
        Random random = new Random();
        List<Integer> availableMoves = new ArrayList<>(); // ToDo: Liste {1,2,3,4} machen
        availableMoves.add(1); // w - Oben
        availableMoves.add(2); // a - Links
        availableMoves.add(3); // s - Unten
        availableMoves.add(4); // d - Rechts
        // ToDo: playField auf high/width umstellen
        if (opponent.getPositionY() + 1 > 14) { // Prüfung auf "d"
            availableMoves.remove((Integer) 4);
        }
        if (opponent.getPositionY() - 1 < 0) { // Prüfung auf "s"
            availableMoves.remove((Integer) 3);
        }
        if (opponent.getPositionX() + 1 > 9) { // Prüfung auf "a"
            availableMoves.remove((Integer) 2);
        }
        if (opponent.getPositionX() - 1 < 0) { // Prüfung auf "w"
            availableMoves.remove((Integer) 1);
        }
        int randomIndex = random.nextInt(availableMoves.size());
        int randomNumber = availableMoves.get(randomIndex);
        if (randomNumber == 1){
            opponent.currentPositionX -= 1;
        } else if (randomNumber == 2) {
            opponent.currentPositionX += 1;
        } else if (randomNumber == 3) {
            opponent.currentPositionY -= 1;
        } else if (randomNumber == 4) {
            opponent.currentPositionY += 1;
        }
    }
}