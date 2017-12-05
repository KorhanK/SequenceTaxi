package com.example.pauline.groupprojecttry;

import android.content.Context;

import java.util.ArrayList;

public class Controller {

    Sequence sequence;
    Player player;

    Context main;

    JSON json;

    public Controller(Context context){


        json = new JSON();
        player = json.loadPlayer(context);
        if (player == null) {
            player = new Player();
        }
        createSequence();


    }


    public int getPlayerLives(){
        int lives = player.getLives();
        return lives;
    }


    public int getPlayerCoins(){
        int coins = player.getCoins();
        return coins;


    }

    public int getPlayerLevel(){
        int level = player.getLevel();
        return level;
    }

    public void createSequence() {

        sequence = new Sequence(player.getLevel());
    }

    public void upLevel() {
        player.setLevel();
        player.setCoins(player.getCoins()+5+player.getLevel()-1);

    }

    public void clearSequence(Context context) {
        sequence.clearSequence();
        json.savePlayer(context, player);
    }

    public void sequenceSetUserInputs(int valueClick) {
        sequence.setUserInputs(valueClick);
    }

    public boolean checkSequence() {
        return sequence.check();

    }

    public boolean lifeDown() {
        player.setLives(player.getLives()-1);
        if(player.getLives()>0)
            return true;
        else
            return false;
    }

    public Controller(int level) {
        sequence = new Sequence(level);
    }

    public void quit() {
        System.exit(0);
    }


    public ArrayList<Integer> getSequenceOfNumber() {
       return sequence.getSequenceOfNumbers();
    }


    public void resetPlayer() {
        player.resetLevel();
        player.setLives(5);
    }
}
