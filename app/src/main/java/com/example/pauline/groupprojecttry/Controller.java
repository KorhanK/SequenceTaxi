package com.example.pauline.groupprojecttry;

public class Controller {

    Sequence sequence;

    public Controller(int level) {
        sequence = new Sequence(level);
    }

    public void quit() {
        System.exit(0);
    }

}
