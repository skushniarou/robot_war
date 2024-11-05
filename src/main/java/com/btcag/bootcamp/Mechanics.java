package com.btcag.bootcamp;

import java.util.*;

import static com.btcag.bootcamp.Battlefield.updateBattlefield;
import static com.btcag.bootcamp.Game.gameOver;
import static com.btcag.bootcamp.Game.robotList;
import static com.btcag.bootcamp.Other.userInputStr;

public class Mechanics {

    //Spieler wird abgefragt was er machen will
    public static void playerTurn(Scanner scanner, Robot player, Battlefield battlefield) {
        updateBattlefield((ArrayList<Robot>) robotList);
        String choice;
        System.out.printf("""
                Du hast folgende Aktionen %s: Welche willst du auswählen?\s
                1 = Bewegen
                2 = Angreifen
                3 = Warten
                4 = Aufgeben
                %n""", player.getName());
        choice = scanner.nextLine();
        label:
        if (choice.matches("[1234]+")) {
            switch (choice) {
                case "1":
                    for (int i = 0; i < player.getMS(); i++) {
                        playerMove(scanner, player, battlefield);
                        updateBattlefield((ArrayList<Robot>) robotList);
                    }
                    break label;
                case "2":
                    // Angreifen
                    break label;
                case "3":
                    //Warten
                    break label;
                case "4":
                    System.out.println("Du hasst kein Kraft mehr... Leider in diese Kampf hasst du verloren");
                    gameOver = false;
                    break label;
            }
        } else {
            System.out.println("Diese Eingabe ist ungültig, geben Sie bitte neu ein!");
        }
    }

    //AI decides what to do on his turn
    static void aiTurn(Robot ai, Battlefield battlefield) {
        //Mögliche Moves die KI machen kann
        aiMove(ai,battlefield);
    }

    //Function to move object on battlefield and check viability of this move
    public static void playerMove(Scanner scanner, Robot player, Battlefield battlefield) {
        boolean check = false;
        while(!check){
            String move = userInputStr("""
                In welche Richtung möchtest du dich bewegen?\s
                w = oben
                a = links
                s = unten
                d = rechts
                e = Bewegung beenden""");
            if (move.matches("[wasdeWASDE]+")){
                switch (move) {
                    case "w", "W" -> {
                        if (!battlefield.hasObjectAt(player.getPositionX(),player.getPositionY()-1)) {
                            if (player.getPositionY() > 0) {
                                player.setPositionY(player.getPositionY()-1);
                                check = true;
                            } else {
                                System.out.println("Das Spielfeld geht nicht weiter nach oben.\nWähle eine andere Richtung.");
                            }
                        } else {
                            System.out.println("In diesem Feld befindet sich schon ein Objekt.\nWähle eine andere Richtung.");
                        }
                    }
                    case "d", "D" -> {
                        if (!battlefield.hasObjectAt(player.getPositionX()+1,player.getPositionY())) {
                            if (player.getPositionX() < battlefield.getWidth()-1) {
                                player.setPositionX(player.getPositionX() + 1);
                                check = true;
                            } else {
                                System.out.println("Das Spielfeld geht nicht weiter nach rechts.\nWähle eine andere Richtung.");
                            }
                        } else {
                            System.out.println("In diesem Feld befindet sich schon ein Objekt.\nWähle eine andere Richtung.");
                        }
                    }
                    case "s", "S" -> {
                        if (!battlefield.hasObjectAt(player.getPositionX(),player.getPositionY()+1)) {
                            if (player.getPositionY() < battlefield.getHeight()-1) {
                                player.setPositionY(player.getPositionY() + 1);
                                check = true;
                            } else {
                                System.out.println("Das Spielfeld geht nicht weiter nach unten.\nWähle eine andere Richtung.");
                            }
                        } else {
                            System.out.println("In diesem Feld befindet sich schon ein Objekt.\nWähle eine andere Richtung.");
                        }
                    }
                    case "a", "A" -> {
                        if (!battlefield.hasObjectAt(player.getPositionX()-1,player.getPositionY())) {
                            if (player.getPositionX() > 0) {
                                player.setPositionX(player.getPositionX() - 1);
                                check = true;
                            } else {
                                System.out.println("Das Spielfeld geht nicht weiter nach links.\nWähle eine andere Richtung.");
                            }
                        } else {
                            System.out.println("In diesem Feld befindet sich schon ein Objekt.\nWähle eine andere Richtung.");
                        }
                    }
                    case "e", "E" -> {
                        check = true;
                    }
                    default -> System.out.println("Ungültige Eingabe");
                }
            } else {
                System.out.println("Ungültige Eingabe!");
            }
        }
        player.displayXYPosition(player);
    }

    public static void aiMove(Robot ai, Battlefield battlefield) {
        Random random = new Random();
        for (int i = 0; i < ai.getMS(); i++) {
            List<Integer> availableMoves = getValidMoveIntegersAI(ai, battlefield);
            int randomIndex = random.nextInt(availableMoves.size());
            int randomNumber = availableMoves.get(randomIndex);
            if (randomNumber == 1 && !battlefield.hasObjectAt(ai.getPositionY(), ai.getPositionX() - 1)) {
                ai.setPositionX(ai.getPositionX() - 1);
                ai.displayXYPosition(ai);
            } else if (randomNumber == 2 && !battlefield.hasObjectAt(ai.getPositionY(), ai.getPositionX() + 1)) {
                ai.setPositionX(ai.getPositionX() + 1);
                ai.displayXYPosition(ai);
            } else if (randomNumber == 3 && !battlefield.hasObjectAt(ai.getPositionY() - 1, ai.getPositionX())) {
                ai.setPositionY(ai.getPositionY() - 1);
                ai.displayXYPosition(ai);
            } else if (randomNumber == 4 && !battlefield.hasObjectAt(ai.getPositionY() + 1, ai.getPositionX())) {
                ai.setPositionY(ai.getPositionY() + 1);
                ai.displayXYPosition(ai);
            }
        }
        updateBattlefield((ArrayList<Robot>) robotList);
    }

    private static List<Integer> getValidMoveIntegersAI(Robot ai, Battlefield battlefield) {
        List<Integer> availableMoves = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        // 1 - w - oben; 2 - a - links; 3 - s - unten; 4 - d - rechts
        if (ai.getPositionY() + 1 > battlefield.getHeight()-1) { // Prüfung auf "s"
            availableMoves.remove((Integer) 4);
        }
        if (ai.getPositionY() - 1 < 0) { // Prüfung auf "w"
            availableMoves.remove((Integer) 3);
        }
        if (ai.getPositionX() + 1 > battlefield.getWidth()-1) { // Prüfung auf "d"
            availableMoves.remove((Integer) 2);
        }
        if (ai.getPositionX() - 1 < 0) { // Prüfung auf "a"
            availableMoves.remove((Integer) 1);
        }
        return availableMoves;
    }
}