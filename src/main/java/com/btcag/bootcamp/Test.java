package com.btcag.bootcamp;

public class Test {
    public static void main(String[] args) {
        Character player = new Character();
        System.out.println(player.name);
        System.out.println(player.nameChar);

        System.out.println();
        player.setName("Olaf");
        player.setNameChar("O");


        System.out.println(player.name);
        System.out.println(player.nameChar);

        Character player2 = new Character("Anna","A",1,1);
        System.out.println();
        System.out.println(player2.name);
        System.out.println(player2.nameChar);

        System.out.println();
        System.out.println(player2.getName());
        System.out.println(player2.getChar());
    }
}
