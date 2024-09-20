package com.btcag.bootcamp;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String [][] spielFeld = new String [15][10];
        for (int i = 0; i < spielFeld.length; i++) {
            for (int j = 0; j < spielFeld[i].length; j++) {
                spielFeld[i][j] = "[ ]";

            }
        }

        for (int i = 0; i < spielFeld.length; i++) {
            for (int j = 0; j < spielFeld[i].length; j++) {
                System.out.print(spielFeld[i][j] + " ");
            }
            System.out.println();
        }

    }
}