package model;


public class Virus {

    public enum Difficulty {
        LOW, MEDIUM, HIGH
    }

    private static double infectionFactor;
    private static double intensity = 1.0;
    private static double cureProgress = 0.0;
    private Difficulty difficulty;

    public Virus(Difficulty difficulty) {
        this.difficulty = difficulty;
        switch (difficulty) {
            case LOW: infectionFactor = 0.01; break;
            case MEDIUM: infectionFactor = 0.02; break;
            case HIGH: infectionFactor = 0.03; break;
        }
    }

    public void infect(World world) {
        world.infect();
    }

    public static void decreaseIntensity(double percentage) {
        intensity *= (1 - percentage);
        if (intensity < 0.1) {
            intensity = 0.1;
        }
    }

    public static double getIntensity() {
        return intensity;
    }

    public static void increaseCureProgress(double percentage) {
        cureProgress += percentage;
        if (cureProgress > 100.0) {
            cureProgress = 100.0;
        }
    }

    public static double getCureProgress() {
        return cureProgress;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public static double getInfectionFactor() {
        return infectionFactor * intensity;
    }
}

