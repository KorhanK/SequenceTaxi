package com.example.pauline.groupprojecttry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Style {

    ArrayList<Integer> images;
    HashMap<Integer, Integer> sequenceButtons;
    HashMap<Integer, String> styles;
    Random randomInt = new Random();
    Controller controller;
    int pos;

    public Style(int pos) {
        sequenceButtons = new HashMap<>();
        images = new ArrayList<>();
        styles = new HashMap<>();

        styles.put(0, "directions");
        styles.put(1, "animals");
        styles.put(2, "numbers");

        loadStyle(pos);
    }

    public int getImages() {
        int value = randomInt.nextInt(images.size());
        return images.get(value);
    }

    public int getPlayButtons(int key) {
        if (key > 0 && key <5) {
            return sequenceButtons.get(key);
        }
        return 0;
    }

    public String getStyle(int pos){
        String style = styles.get(pos);
        return style;
    }

    public void loadStyle(int pos) {
        if(getStyle(pos).equals("directions")){
            directionStyle();
        } else if(getStyle(pos).equals("animals")){
            animalStyle();
        } else if(getStyle(pos).equals("numbers")) {
            numberColorStyle();
        } else{
            directionStyle();
        }

    }

    public void directionStyle() {
        sequenceButtons.put(1, R.drawable.left_white);
        sequenceButtons.put(2, R.drawable.up_white);
        sequenceButtons.put(3, R.drawable.down_white);
        sequenceButtons.put(4, R.drawable.right_white);


        images.add(R.drawable.stockholm_colorful);
        images.add(R.drawable.stockholm_gamlastan);
        images.add(R.drawable.stockholm_gamlastannight);
        images.add(R.drawable.stockholm_globen);
        images.add(R.drawable.stockholm_oldstreet);
        images.add(R.drawable.stockholm_segelstorg);
        images.add(R.drawable.stockholm_winterbridge);
    }

    public void animalStyle() {
        sequenceButtons.put(1, R.drawable.cow_button);
        sequenceButtons.put(2, R.drawable.horse_button);
        sequenceButtons.put(3, R.drawable.pig_button);
        sequenceButtons.put(4, R.drawable.sheep_button);

        images.add(R.drawable.farm_calf);
        images.add(R.drawable.farm_chicks);
        images.add(R.drawable.farm_duckcat);
        images.add(R.drawable.farm_lamb);
        images.add(R.drawable.farm_piglets);
        images.add(R.drawable.farm_poney);
        images.add(R.drawable.farm_sheep);
    }

    public void numberColorStyle() {
        sequenceButtons.put(1, R.drawable.one_color);
        sequenceButtons.put(2, R.drawable.two_color);
        sequenceButtons.put(3, R.drawable.three_color);
        sequenceButtons.put(4, R.drawable.four_color);

        images.add(R.drawable.matrix_1);
        images.add(R.drawable.matrix_binary);
        images.add(R.drawable.matrix_emc2);
        images.add(R.drawable.matrix_fibonaci);
        images.add(R.drawable.matrix_numbers);
        images.add(R.drawable.matrix_pi);
        images.add(R.drawable.matrix_systemfailure);
    }
}
