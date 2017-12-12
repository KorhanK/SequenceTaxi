package com.example.pauline.groupprojecttry;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * Sequence class that creates a random sequence of numbers, gets the player input of sequence
 * numbers, checks.
 */
public class Sequence {

    Random randomInt = new Random();
    ArrayList<Integer> sequenceOfNumbers = new ArrayList<>();
    ArrayList<Integer> userInputs = new ArrayList<>();

    public Sequence(int nbSequence) {
        randomValueInt(nbSequence);
    }

    public ArrayList<Integer> getSequenceOfNumbers() {
        return sequenceOfNumbers;
    }

    /**
     * Method that creates an array list of random numbers
     * @param nbSequence int value that represents the number of random numbers that will be added
     *                   to the array list
     */
    private void randomValueInt(int nbSequence) {
        int value;
        for (int i = 0; i < nbSequence + 2; i++) {
            value = randomInt.nextInt(4) + 1;
            sequenceOfNumbers.add(value);
        }
    }

    /**
     * Method that creates an array list of the players input of the sequence of numbers
     * @param valueClicked int value that represents the number pressed in the screen by the player
     */
    public void setUserInputs(int valueClicked) {
        userInputs.add(valueClicked);
    }

    /**
     * Method that verifies the number of inputs the player pressed in the screen vs the size of the
     * array list with random sequence numbers.
     * @return boolean value that is true when the player inputs are equal to the size of the array
     * list with random sequence numbers.
     */
    public boolean check() {
        if (userInputs.size() < sequenceOfNumbers.size()) {
            return false;
        }
        else {
            for (int i = 0; i < sequenceOfNumbers.size(); i++) {
                if (!Objects.equals(userInputs.get(i), sequenceOfNumbers.get(i)))
                    return false;
            }
            return true;
        }
    }

    public void clearSequence() {
        sequenceOfNumbers.clear();
        userInputs.clear();
    }

    public void userInputReset(){
        userInputs.clear();
    }
}