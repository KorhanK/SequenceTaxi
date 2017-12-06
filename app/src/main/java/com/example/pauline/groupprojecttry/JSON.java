package com.example.pauline.groupprojecttry;

import android.content.Context;
import android.util.JsonReader;
import android.util.JsonWriter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static android.content.Context.MODE_PRIVATE;

public class JSON {

    private String FILENAME = "playerFile";

    public Player loadPlayer(Context context) {
        FileInputStream file;
        try {
            file = context.openFileInput(FILENAME);
        } catch (FileNotFoundException e) {
            return null;
        }

        Player player = null;
        try {
            JsonReader reader = new JsonReader(new InputStreamReader(file, "UTF-8"));

            player = new Player();

            reader.beginObject();
            while (reader.hasNext()) {
                String name = reader.nextName();
                if (name.equals("level")) {
                    player.level = reader.nextInt();
                } else if (name.equals("coins")) {
                    player.coins = reader.nextInt();
                } else if (name.equals("life")) {
                    player.lives = reader.nextInt();
                } else if (name.equals("coinsTotal")) {
                    player.totalCoins = reader.nextInt();
                } else if (name.equals("successSequence")) {
                    player.correctSequence = reader.nextInt();
                } else if (name.equals("preferedStyle")) {
                    player.preferedStyle = reader.nextInt();
                } else {
                    reader.skipValue();
                }
            }
            reader.endObject();
            reader.close();
            file.close();
        } catch (IOException ignored) {
        }
        return player;
    }

    public void savePlayer(Context context, Player player) {
        try {
            FileOutputStream file = context.openFileOutput(FILENAME, MODE_PRIVATE);
            JsonWriter writer = new JsonWriter(new OutputStreamWriter(file));
            writer.beginObject();
            writer.name("level").value(player.getLevel());
            writer.name("coins").value(player.getCoins());
            writer.name("life").value(player.getLives());
            writer.name("coinsTotal").value(player.getTotalCoins());
            writer.name("successSequence").value(player.getCorrectSequence());
            writer.name("preferedStyle").value(player.getPreferedStyle());
            writer.endObject();
            writer.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}