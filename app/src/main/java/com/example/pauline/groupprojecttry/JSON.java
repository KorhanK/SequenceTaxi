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
import java.util.ArrayList;
import java.util.List;

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
                } else if (name.equals("timeLevel")) {
                    player.timeLevel = reader.nextInt();
                } else if (name.equals("boughtStyle")) {
                    player.boughtStyle = readIntegerArray(reader);
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

    private ArrayList<Integer> readIntegerArray(JsonReader reader) throws IOException {
        List<Integer> boughtStyleValue = new ArrayList<>();

        reader.beginArray();
        while (reader.hasNext()) {
            boughtStyleValue.add(reader.nextInt());
        }
        reader.endArray();
        ArrayList<Integer> boughtStyle = new ArrayList<>();
        for (int i = 0; i < boughtStyleValue.size(); i++) {
            boughtStyle.add(boughtStyleValue.get(i));
        }
        return boughtStyle;
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
            writer.name("timeLevel").value(player.getTimeLevel());
            writer.name("boughtStyle");
            writeIntegerArray(writer, player.getBoughtStyle());
            writer.endObject();
            writer.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeIntegerArray(JsonWriter writer, ArrayList<Integer> boughtStyle) throws IOException {
        writer.beginArray();
        for (int value : boughtStyle) {
            writer.value(value);
        }
        writer.endArray();
    }
}