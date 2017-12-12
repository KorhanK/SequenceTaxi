package com.example.pauline.groupprojecttry;


import java.util.ArrayList;

/**
 * Player class that initializes the class fields, and have the following setters and getters
 * methods for: coins, lives, level, correct sequence, total coins, prefered style, and time level.
 */
public class Player {

    public int coins;
    public int lives;
    public int level;
    public int timeLevel;
    public int correctSequence;
    public int totalCoins;
    public int preferedStyle;
    public ArrayList<Integer> boughtStyle;


    /**
     * Constructor method that initializes the Player class fields of coins, lives, level,
     * timeLevel, correctSequence, preferedStyle and sequence.
     */
    public Player() {

        coins=0;
        lives=5;
        level=1;
        timeLevel = 1;
        correctSequence=0;
        totalCoins=0;
        preferedStyle = 0;
        boughtStyle = new ArrayList<>();
        boughtStyle.add(0);
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void paidCoins(int paidCoins) {
        coins = coins - paidCoins;
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
        if (level <= 6) {
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

    public int getPreferedStyle() {
        return preferedStyle;
    }

    public void setPreferedStyle(int pos) {
        this.preferedStyle = pos;
    }

    public int getTimeLevel() {
        return timeLevel;
    }

    /**
     *  Method that sets the time of the different levels of the game.
     *  "Edmundo Note: can we explain what the if and else statements do?
     */
    public void setTimeLevel() {
        if (level == 1) {
            if (timeLevel >= 2) {
                setLevel();
                timeLevel = 1;
            } else {
                timeLevel++;
            }
        } else if (level == 2) {
            if (timeLevel >= 3) {
                setLevel();
                timeLevel = 1;
            } else {
                timeLevel++;
            }
        } else if (level == 3) {
            if (timeLevel >= 4) {
                setLevel();
                timeLevel = 1;
            } else {
                timeLevel++;
            }
        } else if (level == 4) {
            if (timeLevel >= 5) {
                setLevel();
                timeLevel = 1;
            } else {
                timeLevel++;
            }
        } else if (level == 5) {
            if (timeLevel >= 6) {
                setLevel();
                timeLevel = 1;
            } else {
                timeLevel++;
            }
        } else if (level == 6) {
            if (timeLevel >= 7) {
                setLevel();
                timeLevel = 1;
            } else {
                timeLevel++;
            }
        }
    }

    public void addBoughtStyle(int newStyle) {
        if (!isBoughtStyle(newStyle)) {
            boughtStyle.add(newStyle);
        }
    }

    public boolean isBoughtStyle(int style) {
        boolean found = false;
        for (int i = 0; i < boughtStyle.size(); i++) {
            if (boughtStyle.get(i) == style) {
                found = true;
            }
        }
        return found;
    }

    public ArrayList<Integer> getBoughtStyles() {
        return boughtStyle;
    }

}

