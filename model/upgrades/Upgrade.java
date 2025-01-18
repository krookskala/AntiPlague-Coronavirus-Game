package model.upgrades;

public abstract class Upgrade {

    private final String NAME;
    private static int cost = 3;

    public abstract void upgrade();

    public Upgrade(String NAME) { this.NAME = NAME; }

    public static void increaseCost() { cost += 2; }

    public String getNAME() { return NAME; }

    public static int getCost() { return cost; }
}
