import java.util.Arrays;
import java.util.Random;

/**
 * Created by brollins on 10/15/2015.
 */
public class BanditSimulator {

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

    /**
     * pulls the chosen bandit.  If you win (the random number is less than the bandit's value) returns a 1, otherwise
     * returns a 0.
     *
     * @param bandit the bandit to pull
     * @return a 1 if you win, otherwise a 0
     */
    public int pull(int bandit) {

        if (bandit < 0 || bandit > numBandits - 1)
            throw new IllegalArgumentException("bandit must be between 0 and " + (numBandits - 1));

        return (bandits[bandit].pull()) ? 1 : 0;
    }

    @Override
    public String toString() {
        String returnString = "BanditSimulator{ bandits = [ ";
        for (Bandit bandit : bandits) {
            returnString += bandit.toString() + ", ";
        }
        returnString += "]}";
        return returnString;
    }
}
