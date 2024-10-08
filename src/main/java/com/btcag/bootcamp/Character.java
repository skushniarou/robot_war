package com.btcag.bootcamp;

public class Character {

    String name;
    String nameChar;

    Character() {
        name = "Test";
        nameChar = "T";
    }

    Character(String initialName, String initialNameChar) {
        name = initialName;
        nameChar = initialNameChar;
    }

    String getName (){
        return name;
    }

    String getChar () {
        return nameChar;
    }

    void setName (String name){
        this.name = name;
    }

    void setNameChar (String nameChar){
        this.nameChar = nameChar;
    }
}
