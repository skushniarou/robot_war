package com.btcag.bootcamp;

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

}
