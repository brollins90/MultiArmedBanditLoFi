package bandit;

import simulator.Simulator;

import java.util.Random;

/**
 * Created by brollins on 10/15/2015.
 */
public class BanditSimulator implements Simulator {

    Bandit[] bandits;
    int numBandits;
    Random random = new Random();

    public BanditSimulator(int numBandits) {
        this.numBandits = numBandits;

        initialize();
    }

    /**
     * create the bandits and sets their initial values
     */
    protected void initialize() {

        bandits = new Bandit[numBandits];
        for (int i = 0; i < numBandits; i++) {
            bandits[i] = new Bandit(random);
        }
    }

    public int getNumberOfChoices() {
        return numBandits;
    }

    public int pull(int bandit) {

        if (bandit < 0 || bandit > numBandits - 1)
            throw new IllegalArgumentException("bandit must be between 0 and " + (numBandits - 1));

        return (bandits[bandit].pull()) ? 1 : 0;
    }

    @Override
    public String toString() {
        String returnString = "bandit.BanditSimulator{ bandits = [ ";
        for (Bandit bandit : bandits) {
            returnString += bandit.toString() + ", ";
        }
        returnString += "]}";
        return returnString;
    }
}
