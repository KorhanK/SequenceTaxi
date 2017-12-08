package com.example.pauline.groupprojecttry;

/**
 * Created by tmp-sda-1108 on 11/30/17.
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

    public Player() {
        coins=0;
        lives=5;
        level=1;
        timeLevel = 1;
        correctSequence=0;
        totalCoins=0;
        preferedStyle = 0;
    }


//    public int addSequence(boolean check) {
//        check=false;
//
//        if (check==true) {
//            sequence=+1;
//        }
//        else if(check==false) {
//            sequence=sequence;
//        }
//
//        return sequence;
//    }
//    public int incresLevel() {
//        if(sequence==+1) {
//            level=level+1;
//        }
//        return level;
//    }
//    public int addCoins() {
//
//        if (sequence==+1) {
//            coins=coins+5;
//        }
//        return coins;
//    }
//
//    public void subtractLives() {
//        if (lives > 0) {
//            lives--;
//        }
//    }

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
     *  Increasing the level depends on the number of times the user succeeds the level.
     *  If the player is on level 2, the level increases after the player enters 3 right sequences.
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
