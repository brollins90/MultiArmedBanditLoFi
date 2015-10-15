package simulator;

import java.util.Random;

/**
 * Created by brollins on 10/15/2015.
 */
public class RandomPuller implements Puller {

    Simulator simulator;
    Random random;

    public RandomPuller(Simulator simulator) {
        this(simulator, new Random());
    }

    public RandomPuller(Simulator simulator, Random random) {
        this.simulator = simulator;
        this.random = random;
    }

    public void pull(int numberOfPulls) {

        int numChoices = simulator.getNumberOfChoices();
        int choice;

        for (int i = 0; i < numberOfPulls; i++) {
            choice = (int) (numChoices * random.nextDouble());
            simulator.pull(choice);
        }
    }
}
