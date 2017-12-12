package com.example.pauline.groupprojecttry;

public class StyleNumbers extends Style {
    public StyleNumbers() {
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

    @Override
    public int getId() {
        return NUMBERS_STYLE;
    }

    @Override
    public String getName() {
        return "numbers";
    }
}
