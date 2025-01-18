package model;

import model.transport.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Country implements Serializable, Comparable<Country> {

    private final String NAME;
    private final int ID;
    private final long POPULATION;
    private final double LANDAREA, POPULATION_DENSITY;
    private final List<Transport> meansOfTransportation;
    private double peopleInfected;
    private int totalTransportVirality;

    public Country(String NAME, int ID, long POPULATION, double LANDAREA, double POPULATION_DENSITY) {
        this.NAME = NAME;
        this.ID = ID;
        this.POPULATION = POPULATION;
        this.LANDAREA = LANDAREA;
        this.POPULATION_DENSITY = POPULATION_DENSITY;
        meansOfTransportation = new ArrayList<>();
        peopleInfected = 0;
        totalTransportVirality = 0;
        transportFactory();
        for (Transport t : meansOfTransportation)
            totalTransportVirality += t.getOwnViralityFactor();
    }

    private void transportFactory() {
        meansOfTransportation.add(new Cars());
        meansOfTransportation.add(new Coaches());
        meansOfTransportation.add(new Boats());
        if (POPULATION > 2000000)
            meansOfTransportation.add(new Trains());
        if (POPULATION > 10000000)
            meansOfTransportation.add(new Ships());
        if (POPULATION > 50000000)
            meansOfTransportation.add(new Planes());
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(ID).append(" ").append(NAME).append(" ").append(POPULATION).append(" ").append(LANDAREA)
                .append(" ").append(POPULATION_DENSITY);
        for (Transport transport : meansOfTransportation)
            str.append(" ").append(transport);
        return str.toString();
    }

    public double infect() {
        if (peopleInfected < POPULATION) {
            double infectedNew;
            if (peopleInfected == 0)
                infectedNew = Math.random() > 0.05 ? 1 : 0;
            else
                infectedNew = peopleInfected * (1 + Virus.getInfectionFactor() * totalTransportVirality / 19) *
                        (POPULATION - peopleInfected) / POPULATION;
            if (peopleInfected + infectedNew > POPULATION)
                infectedNew = POPULATION - peopleInfected;
            peopleInfected += infectedNew;
            disableTransport();
            return infectedNew;
        }
        return 0;
    }

    private void disableTransport() {
        double percentageInfected = peopleInfected / (double) POPULATION;
        for (Transport t : meansOfTransportation) {
            boolean previouslyDisabled = t.disabled;
            t.disable(percentageInfected);
            if (t.disabled & !previouslyDisabled)
                totalTransportVirality -= t.getOwnViralityFactor();
        }
    }

    public String getNAME() {
        return NAME;
    }

    public long getPOPULATION() {
        return POPULATION;
    }

    public double getLANDAREA() {
        return LANDAREA;
    }

    public double getPOPULATION_DENSITY() {
        return POPULATION_DENSITY;
    }

    public double getPeopleInfected() {
        return peopleInfected;
    }

    public String getActiveTransport() {
        StringBuilder sb = new StringBuilder();
        for (Transport t : meansOfTransportation)
            if (!t.disabled)
                sb.append(t).append(", ");
        return sb.toString();
    }

    public List<Transport> getMeansOfTransportation() {
        return meansOfTransportation;
    }

    @Override
    public int compareTo(Country o) {
        return NAME.compareTo(o.NAME);
    }
}
