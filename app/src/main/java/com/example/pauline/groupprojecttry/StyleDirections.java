package com.example.pauline.groupprojecttry;

public class StyleDirections extends Style {
    public StyleDirections() {
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

    @Override
    public int getId() {
        return DIRECTIONS_STYLE;
    }

    @Override
    public String getName() {
        return "directions";
    }
}