package bandit;

import simulator.Puller;
import simulator.Simulator;

import java.util.Random;

/**
 * Created by brollins on 10/16/2015.
 */
public class BayesianPuller implements Puller {

    int totalPulls;
    double[] rating;
    int[] pulls;
    int[] wins;

    boolean exploring;

    Simulator simulator;
    Random random;

    public BayesianPuller(Simulator simulator) {
        this(simulator, new Random());
    }

    public BayesianPuller(Simulator simulator, Random random) {
        this.simulator = simulator;
        this.random = random;

        int numberOfChoices = simulator.getNumberOfChoices();

        totalPulls = 0;
        rating = new double[numberOfChoices];
        for (int i = 0; i < rating.length; i++) {
            rating[i] = 1;
        }
        pulls = new int[numberOfChoices];
        wins = new int[numberOfChoices];

        exploring = true;
    }

    /**
     * Changes to exploit mode where we will only pull the best lever
     */
    public void setExploitMode() {
        exploring = false;
    }

    /**
     * Changes to explore mode where we will try all levers to find the best
     */
    public void setExploreMode() {
        exploring = true;
    }

    private void decreaseRating(int choice) {

        rating[choice] = (rating[choice] > 1) ? rating[choice]-- : 1;
    }

    private void increaseRating(int choice) {

        rating[choice]++;
    }

    private int getExploreChoice() {

        int choice = 0;

        double totalRatings = 0;
        for (int i = 0; i < rating.length; i++) {
            totalRatings += rating[i];
        }

        double randomNumber = totalRatings * random.nextDouble();
        double runningTotal = 0;

        for (int i = 0; i < rating.length; i++) {

            runningTotal += rating[i];
            if (randomNumber < runningTotal) {
                choice = i;
                break;
            }
        }
        return choice;
    }


    private int getExploitChoice() {
        int choice = 0;

        double largest = -999999;

        for (int i = 0; i < rating.length; i++) {
            if (rating[i] > largest) {
                largest = rating[i];
                choice = i;
            }
        }

        return choice;
    }


    public void pull(int numberOfPulls) {

        for (int j = 0; j < numberOfPulls; j++) {

            totalPulls++;
            int choice = (exploring) ? getExploreChoice() : getExploitChoice();
            int result = simulator.pull(choice);

            pulls[choice]++;
            if (result == 1) {

                wins[choice]++;
                increaseRating(choice);
            } else {
                decreaseRating(choice);
            }
        }
    }
}
