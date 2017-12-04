package com.example.pauline.groupprojecttry;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by pauline on 04/12/2017.
 */

public class Style {

    ArrayList<Integer> images;
    ArrayList<Integer> SequenceButtons;
    HashMap<Integer, Integer> playButtons;

    public Style() {
        playButtons = new HashMap<>();
        playButtons.put(1, R.drawable.left_white);
        playButtons.put(2, R.drawable.up_white);
        playButtons.put(3, R.drawable.down_white);
        playButtons.put(4, R.drawable.right_white);

    }

    public void getImages() {
        images = new ArrayList<>();
        //images.add(R.drawable.background_v1);
    }

    public int getPlayButtons(int value) {
        if (value > 0 && value <5) {
            return playButtons.get(value);
        }
        return 0;
    }
}
