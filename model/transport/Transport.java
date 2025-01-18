package model.transport;

import java.io.Serializable;

public abstract class Transport implements Serializable {
    protected double ownViralityFactor;
    static double viralityFactor = 0;
    public boolean disabled = false;
    protected double infectionCutOff;

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    public boolean disable(double percentageInfected) {
        if (percentageInfected >= infectionCutOff)
            disabled = true;
        return disabled;
    }

    public void decreaseCutOff(double percentage) {
        infectionCutOff *= (1 - percentage);
    }

    public static void decreaseVirality(double factor) { viralityFactor -= factor; }

    public double getOwnViralityFactor() {
        return ownViralityFactor;
    }
}