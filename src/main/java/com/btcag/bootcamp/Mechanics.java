package com.btcag.bootcamp;

import java.util.*;

import static com.btcag.bootcamp.Battlefield.updateBattlefield;
import static com.btcag.bootcamp.Game.*;
import static com.btcag.bootcamp.Other.userInputInt;
import static com.btcag.bootcamp.Other.userInputStr;

public class Mechanics {

    //Spieler wird abgefragt was er machen will
    public static void playerTurn(Robot player, Battlefield battlefield) {
        String choice = userInputStr(String.format(
                "Du hast folgende Aktionen %s:\nWelche willst du auswählen?\n" +
                        "1 = Bewegen\n" +
                        "2 = Angreifen\n" +
                        "3 = Warten\n" +
                        "4 = Aufgeben\n",
                player.getName()));
        label:
        if (choice.matches("[1234]+")) {
            switch (choice) {
                case "1":
                    playerMove(player, battlefield);
                    playerAttack(player, battlefield);
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
    public static void playerMove(Robot player, Battlefield battlefield) {
        for (int i = 0; i < player.getMS(); i++) {
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
                            if (!battlefield.notValidMove(player.getPositionX(), player.getPositionY() - 1)) {
                                player.setOldPositionY(player.getPositionY());
                                player.setPositionY(player.getPositionY()-1);
                                check = true;
                            } else {
                                System.out.println("Du kannst nicht weiter Bewegen.\nWähle eine andere Richtung.");
                            }
                        }
                        case "d", "D" -> {
                            if (!battlefield.notValidMove(player.getPositionX() + 1, player.getPositionY())) {
                                player.setOldPositionX(player.getPositionX());
                                player.setPositionX(player.getPositionX() + 1);
                                check = true;
                            } else {
                                System.out.println("Du kannst nicht weiter Bewegen.\nWähle eine andere Richtung.");
                            }
                        }
                        case "s", "S" -> {
                            if (!battlefield.notValidMove(player.getPositionX(), player.getPositionY() + 1)) {
                                player.setOldPositionY(player.getPositionY());
                                player.setPositionY(player.getPositionY() + 1);
                                check = true;
                            } else {
                                System.out.println("Du kannst nicht weiter Bewegen.\nWähle eine andere Richtung.");
                            }
                        }
                        case "a", "A" -> {
                            if (!battlefield.notValidMove(player.getPositionX() - 1, player.getPositionY())) {
                                player.setOldPositionX(player.getPositionX());
                                player.setPositionX(player.getPositionX() - 1);
                                check = true;
                            } else {
                                System.out.println("Du kannst nicht weiter Bewegen.\nWähle eine andere Richtung.");
                            }
                        }
                        case "e", "E" -> {
                            i = player.getMS();
                            check = true;
                        }
                        default -> System.out.println("Ungültige Eingabe");
                    }
                } else {
                    System.out.println("Ungültige Eingabe!");
                }
            }
            updateBattlefield((ArrayList<Robot>) robotList);
            player.displayXYPosition(player);
        }
    }

    public static void playerAttack(Robot player, Battlefield battlefield){
        List<Robot> validTargetList = getValidTargetList(player);
        // Display the valid targets with their names and numbers
        for (int i = 0; i < validTargetList.size(); i++) {
            System.out.println((i + 1) + ") " + validTargetList.get(i).getName());
        }
        int targetIndex = userInputInt("Wer sollte angegriffen werden? (Gebe nummer ein):");
        if (targetIndex >= 0 && targetIndex < validTargetList.size()) {
            Robot target = validTargetList.get(targetIndex);
            // Proceed with the attack on the selected target
            attackTarget(player, target);
        } else {
            System.out.println("Invalid selection. Please try again.");
        }
    }

    private static List<Robot> getValidTargetList (Robot currRobot){
        List<Robot> targetList = getRobotList();
        //Player Roboter aus der Liste löschen, wenn identisch ist
        targetList.removeIf(target -> target.equals(currRobot) || target.getName().equals(currRobot.getName()));
        targetList.removeIf(target -> !isInRange(currRobot, target));
        return targetList;
    }

    private static boolean isInRange(Robot currRobot, Robot target) {
        //Ausrechnen ob Target ist in Range von active Roboter
        double distance = Math.sqrt(
                Math.pow(target.getPositionX() - currRobot.getPositionX(), 2) +
                Math.pow(target.getPositionY() - currRobot.getPositionY(), 2)
        );
        return distance <= currRobot.getAR();
    }

    private static void attackTarget(Robot currRobot, Robot target) {
        //Calculate damage and outcome
        System.out.println(currRobot.getName() + " greift " + target.getName() + " an!");
    }

    public static void aiMove(Robot ai, Battlefield battlefield) {
        Random random = new Random();
        for (int i = 0; i < ai.getMS(); i++) {
            List<Integer> availableMoves = getValidMoveIntegersAI(ai, battlefield);
            int randomIndex = random.nextInt(availableMoves.size());
            int randomNumber = availableMoves.get(randomIndex);
            if (randomNumber == 1) {
                ai.setOldPositionX(ai.getPositionX());
                ai.setPositionX(ai.getPositionX() - 1);
                ai.displayXYPosition(ai);
            } else if (randomNumber == 2) {
                ai.setOldPositionX(ai.getPositionX());
                ai.setPositionX(ai.getPositionX() + 1);
                ai.displayXYPosition(ai);
            } else if (randomNumber == 3) {
                ai.setOldPositionY(ai.getPositionY());
                ai.setPositionY(ai.getPositionY() - 1);
                ai.displayXYPosition(ai);
            } else if (randomNumber == 4) {
                ai.setOldPositionY(ai.getPositionY());
                ai.setPositionY(ai.getPositionY() + 1);
                ai.displayXYPosition(ai);
            }
            updateBattlefield((ArrayList<Robot>) robotList);
        }
    }

    private static List<Integer> getValidMoveIntegersAI(Robot ai, Battlefield battlefield) {
        List<Integer> availableMoves = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        // 1 - a - links; 2 - d - rechts; 3 - w - oben; 4 - s - unten
        if ((ai.getPositionY() + 1 > battlefield.getHeight()-1) || battlefield.notValidMove(ai.getPositionX(), ai.getPositionY() + 1)) { // Prüfung auf "s"
            availableMoves.remove((Integer) 4);
        }
        if ((ai.getPositionY() - 1 < 0) || battlefield.notValidMove(ai.getPositionX(), ai.getPositionY() - 1)) { // Prüfung auf "w"
            availableMoves.remove((Integer) 3);
        }
        if ((ai.getPositionX() + 1 > battlefield.getWidth()-1) || battlefield.notValidMove(ai.getPositionX() + 1, ai.getPositionY())) { // Prüfung auf "d"
            availableMoves.remove((Integer) 2);
        }
        if ((ai.getPositionX() - 1 < 0) || battlefield.notValidMove(ai.getPositionX() - 1, ai.getPositionY())) { // Prüfung auf "a"
            availableMoves.remove((Integer) 1);
        }
        return availableMoves;
    }
}