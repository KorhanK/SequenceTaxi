package com.example.pauline.groupprojecttry;


/**
 * Player class that initializes the class fields, and have the following setters and getters methods for: coins, lives, level, correct sequence, total coins, prefered style, and time level. .
 */
public class Player {

    public int coins;
    public int lives;
    public int level;
    public int timeLevel;
    public int correctSequence;
    public int totalCoins;
    public int preferedStyle;
    public int sequence;

    /**
     * Constructor method that initializes the Player class fields of coins, lives, level, timeLevel, correctSequence, preferedStyle and sequence.
     */
    public Player() {

        coins=0;
        lives=5;
        level=1;
        timeLevel = 1;
        correctSequence=0;
        totalCoins=0;
        preferedStyle = 0;
    }

    //Edmundo Note: do we need this method?
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

    //Edmundo Note: do we need this method?
    public int incresLevel() {
        if(sequence==+1) {
            level=level+1;
        }
        return level;
    }

    //Edmundo Note: do we need this method?
    public int addCoins() {

        if (sequence==+1) {
            coins=coins+5;
        }
        return coins;
    }

    //Edmundo Note: do we need this method?
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
        if (level <= 6) {
            level++;
        }
    }

    public void resetLevel() {
        level = 1;
    }

    //Edmundo Note: Where do we set the correct sequence?
    public int getCorrectSequence() {
        return correctSequence;
    }

    //Edmundo Note: Where do we set the total coins?
    public int getTotalCoins() {
        return totalCoins;
    }

    /**
     * Method that gets the selected prefered icon image of buttons.
     * @return int value with the selected prefered icon image of buttons.
     */
    public int getPreferedStyle() {
        return preferedStyle;
    }

    /**
     * Method that sets the prefered style by selecting the icon image of the buttons we want to play with, e.g. arrows, numbers or animals
     * @param pos int value that represents the prefered style of the icon image of the buttons we want to play with.
     */
    public void setPreferedStyle(int pos) {
        this.preferedStyle = pos;
    }

    /**
     * Method that gets ... please continue
     * @return int value that ... please continue
     */
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
}