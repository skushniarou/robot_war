package com.btcag.bootcamp;

import com.btcag.bootcamp.Views.DisplayRobotListView;
import com.btcag.bootcamp.Views.IntroScreenView;

import java.util.ArrayList;

import static com.btcag.bootcamp.Battlefield.*;
import static com.btcag.bootcamp.Game.*;
import static com.btcag.bootcamp.Mechanics.*;

public class Main {

    public static void main(String[] args) {
        //Intro
        IntroScreenView.introduction();

        //Spielfeld generieren + eine Spielerliste aus Roboter erstellen
        createGameComponents();

        //Gibt Liste von Spieler aus mit Attributen
        DisplayRobotListView.displayRobotList();

        //Game with Turnorder
        displayBattlefield((ArrayList<Robot>) robotList);
        while (isGameOn()) {
            for (int i = 0; i < getRobotListLength(); i++) {
                if (robotList.get(i).getIsHuman()) {
                    playerTurn(robotList.get(i), battlefield);
                } else {
                    aiTurn(robotList.get(i), battlefield);
                }
                checkWinCondition(i,(ArrayList<Robot>) robotList);
            }
        }
    }
}