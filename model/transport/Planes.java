package model.transport;

public class Planes extends Transport {
    public Planes() {
        ownViralityFactor = viralityFactor + 5;
        infectionCutOff = 0.3;
    }
}
