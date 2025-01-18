package model;

import java.io.*;
import java.util.*;

public class World {
    private final List<Country> countries;
    private long totalPopulation;
    private double totalInfected;
    private static double points;
    private static double totalPoints;

    // Cure-related variable
    private static final double CURE_RESEARCH_COST = 10;
    private static final double CURE_INCREMENT = 0.5;

    public World() {
        points = 1.0;
        totalPoints = points;
        countries = new ArrayList<>();
        totalPopulation = 0;
        totalInfected = 0;
        countriesReader();
    }

    private void countriesReader() {
        ObjectInputStream in;
        FileInputStream fis;
        try {
            fis = new FileInputStream("src/resources/data/countries");
            in = new ObjectInputStream(fis);
            try {
                while (true) {
                    Country country = (Country) in.readObject();
                    totalPopulation += country.getPOPULATION();
                    countries.add(country);
                }
            } catch (EOFException ignored) {}
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void infect() {
        for (Country c : countries)
            totalInfected += c.infect();
    }

    public void researchCure() {
        if (points >= CURE_RESEARCH_COST) {
            points -= CURE_RESEARCH_COST;
            Virus.increaseCureProgress(CURE_INCREMENT);
        }
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void addPoints() { points += 0.5; }

    public static void removePoints(int howMany) { points -= howMany; }

    public long getTotalPopulation() {
        return totalPopulation;
    }

    public double getTotalInfected() {
        return totalInfected;
    }

    public static double getPoints() { return points; }

    public static double getTotalPoints() { return totalPoints; }

    public double getCureProgress() {
        return Virus.getCureProgress() / 100.0;
    }

    public void increaseCureProgress(double percentage) {
        Virus.increaseCureProgress(percentage);
    }
}
