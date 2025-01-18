package model.transport;

public class Trains extends Transport {
    public Trains() {
        ownViralityFactor = viralityFactor + 3;
        infectionCutOff = 0.5;
    }
}
