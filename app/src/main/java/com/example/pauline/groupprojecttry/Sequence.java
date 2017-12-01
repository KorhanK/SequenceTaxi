package com.example.pauline.groupprojecttry;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

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

    private void randomValueInt(int nbSequence) {
        int value;
        for (int i = 0; i < nbSequence + 2; i++) {
            value = randomInt.nextInt(4) + 1;
            sequenceOfNumbers.add(value);
        }
    }

    public void setUserInputs(int valueClicked) {
        userInputs.add(valueClicked);
    }

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
}
