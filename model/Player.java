package model;

import java.io.Serializable;

public class Player implements Serializable, Comparable<Player> {
    private final String NAME;
    private final int POINTS;
    private final int TIME;
    private final Virus.Difficulty DIFFICULTY;

    public Player(String NAME, int POINTS, int TIME, Virus.Difficulty DIFFICULTY) {
        this.NAME = NAME;
        this.POINTS = POINTS;
        this.TIME = TIME;
        this.DIFFICULTY = DIFFICULTY;
    }

    public String getNAME() { return NAME; }

    public int getPOINTS() { return POINTS; }

    public int getTIME() { return TIME; }

    public Virus.Difficulty getDIFFICULTY() { return DIFFICULTY; }

    @Override
    public int compareTo(Player o) {
        return Integer.compare(this.POINTS, o.POINTS); // Sort by points
    }
}
