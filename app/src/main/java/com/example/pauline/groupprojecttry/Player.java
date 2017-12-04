package com.example.pauline.groupprojecttry;

/**
 * Created by tmp-sda-1108 on 11/30/17.
 */

public class Player {

    public int coins;
    public int lives;
    public int level;
    public int correctSequence;
    public int totalCoins;
    public String prefferStyle;
    public int sequence;

    public Player() {
        coins=0;
        lives=5;
        level=1;
        correctSequence=0;
        totalCoins=0;
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

    public void subtractLives() {
        if (lives > 0) {
            lives--;
        }
    }


    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel() {
        if (level < 6) {
            level++;
        }
    }

    public void resetLevel() {
        level = 1;
    }

    public int getCorrectSequence() {
        return correctSequence;
    }

    public int getTotalCoins() {
        return totalCoins;
    }

    public void setCorrectSequence(int correctSequence) {
        this.correctSequence = correctSequence;
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
