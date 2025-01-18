package model.transport;

public class Boats extends Transport {
    public Boats() {
        ownViralityFactor = viralityFactor + 2;
        infectionCutOff = 1;
    }
}
