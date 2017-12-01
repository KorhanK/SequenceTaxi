package com.example.pauline.groupprojecttry;

/**
 * Created by tmp-sda-1108 on 11/30/17.
 */

public class Player {

    private int coins;
    private int lives;
    private int level;
    private int correctSequence;
    private int totalCoins;
    private String prefferStyle;
    private int sequence;

    public Player() {
        int coins=0;
        int lives=5;
        int level=0;
        int correctSequence=0;
        int totalCoins=0;
    }

    public int addSequence(boolean check) {
        check=false;

        if (check==true) {
            sequence=+1;
        }
        else if(check==false) {
            sequence=sequence;
        }

        return sequence;
    }
    public int incresLevel() {
        if(sequence==+1) {
            level=level+1;
        }
        return level;
    }
    public int addCoins() {

        if (sequence==+1) {
            coins=coins+5;
        }
        return coins;
    }

    public int subtractLives() {
        if(sequence==sequence) {
            lives=lives-1;
        }
        return lives;
    }


    public int getCoins() {
        return coins;
    }
    public void setCoins(int coins) {
        this.coins = coins;
    }
    public int getLive2s() {
        return lives;
    }
    public void setLives(int lives) {
        this.lives = lives;
    }
    public int getLevel() {
        return level;
    }
    public void setLevels(int level) {
        this.level = level;
    }
    public int getCorrectSequence() {
        return correctSequence;
    }
    public void setCorrectSequence(int correctSequence) {
        this.correctSequence = correctSequence;
    }
    public int getTotalCoins() {
        return totalCoins;
    }
    public void setTotalCoins(int totalCoins) {
        this.totalCoins = totalCoins;
    }
    public String getPrefferStyle() {
        return prefferStyle;
    }
    public void setPrefferStyle(String prefferStyle) {
        this.prefferStyle = prefferStyle;
    }



}
