package com.btcag.bootcamp;

public class Battlefield {

    public int hight;
    public int width;
    public static String [][] battlefieldArray;

    Battlefield() {
        hight = 0;
        width = 0;
        battlefieldArray = new String[hight][width];
    }

    Battlefield(int hight, int width){
        this.hight = hight;
        this.width = width;
        battlefieldArray = new String[hight][width];
    }

    static Battlefield createBattlefield(Battlefield battlefield) {
        String[][] newBattlefield = new String[battlefield.hight][battlefield.width];
        for (int i = 0; i < newBattlefield.length; i++) {
            for (int j = 0; j < newBattlefield[i].length; j++) {
                newBattlefield[i][j] = "[ ]";
            }
        }
        battlefield.battlefieldArray = newBattlefield;
        return battlefield;
    }

    //Updates Battlefield on users interface
    public static void updateBattlefield(Battlefield battlefield, Character player, Character opponent) {
        System.out.println();
        for (int i = 0; i < battlefield.hight; i++) {
            for (int j = 0; j < battlefield.width; j++) {
                if (i == player.getPositionX() && j == player.getPositionY()) {
                    System.out.print(player.getChar());
                } else if (i == opponent.getPositionX() && j == opponent.getPositionY()) {
                    System.out.print(opponent.getChar());
                } else {
                    System.out.print(battlefield.battlefieldArray[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
