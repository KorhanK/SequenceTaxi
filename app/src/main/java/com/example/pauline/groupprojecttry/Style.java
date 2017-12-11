package com.example.pauline.groupprojecttry;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public abstract class Style {
    public static int DIRECTIONS_STYLE = 0;
    public static int ANIMALS_STYLE = 1;
    public static int NUMBERS_STYLE = 2;

    protected ArrayList<Integer> images;
    protected HashMap<Integer, Integer> sequenceButtons;
    private Random randomInt = new Random();
    private int id;
    private String name;

    public Style() {
        sequenceButtons = new HashMap<>();
        images = new ArrayList<>();
    }

    public static Style build(int styleDef) {
        switch (styleDef) {
            case 1:
                return new StyleAnimals();
            case 2:
                return new StyleNumbers();
            default:
                return new StyleDirections();
        }
    }

    public static Style build(String name) {
        switch (name) {
            case "animals":
                return new StyleAnimals();
            case "numbers":
                return new StyleNumbers();
            default:
                return new StyleDirections();
        }
    }

    public int getImage() {
        int value = randomInt.nextInt(images.size());
        return images.get(value);
    }


    public int getPlayButtons(int key) {
        if (key > 0 && key <5) {
            return sequenceButtons.get(key);
        }
        return 0;
    }

    public List<Style> getAllStyles() {
        List<Style> styles = new ArrayList<>();
        styles.add(Style.build(DIRECTIONS_STYLE));
        styles.add(Style.build(ANIMALS_STYLE));
        styles.add(Style.build(NUMBERS_STYLE));
        return styles;
    }

    public abstract int getId();

    public abstract String getName();
}
