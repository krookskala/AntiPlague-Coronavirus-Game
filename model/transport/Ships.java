package model.transport;

public class Ships extends Transport {
    public Ships() {
        ownViralityFactor = viralityFactor + 4;
        infectionCutOff = 0.4;
    }
}
