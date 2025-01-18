package model.transport;

public class Coaches extends Transport {
    public Coaches() {
        ownViralityFactor = viralityFactor + 4;
        infectionCutOff = 1;
    }
}
