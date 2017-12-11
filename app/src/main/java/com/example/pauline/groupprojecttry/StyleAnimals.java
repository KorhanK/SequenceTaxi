package com.example.pauline.groupprojecttry;

/**
 * Created by pauline on 10/12/2017.
 */

public class StyleAnimals extends Style {
    public StyleAnimals() {
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

    @Override
    public int getId() {
        return ANIMALS_STYLE;
    }

    @Override
    public String getName() {
        return "animals";
    }
}
