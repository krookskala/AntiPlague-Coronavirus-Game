package model.transport;

public class Cars extends Transport {
    public Cars() {
        ownViralityFactor = viralityFactor + 1;
        infectionCutOff = 1;
    }
}
