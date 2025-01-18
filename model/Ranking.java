package model;

import java.io.*;
import java.util.*;

public class Ranking {

    private static List<Player> players = new ArrayList<>();

    public static List<Player> readRanking() {
        players.clear();

        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream("src/resources/data/ranking");
            ois = new ObjectInputStream(fis);
            while (true)
                players.add((Player) ois.readObject());

        } catch (EOFException ignored) {}
        catch (IOException | ClassNotFoundException ex) { ex.printStackTrace(); }
        return players;
    }

    public static void saveRanking() {
        if (players.isEmpty())
            return;

        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream("src/resources/data/ranking");
            oos = new ObjectOutputStream(fos);
            for (Player p : players)
                oos.writeObject(p);
            oos.close();
            fos.close();
        } catch (IOException ex) { ex.printStackTrace(); }
    }

    public static void addPlayer(String name, int points, int time, Virus.Difficulty difficulty) {
        players = readRanking();
        players.add(new Player(name, points, time, difficulty));
        Collections.sort(players);
        Collections.reverse(players);
        saveRanking();
    }
}