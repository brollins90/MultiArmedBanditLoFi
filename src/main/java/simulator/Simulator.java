package simulator;

/**
 * Created by brollins on 10/15/2015.
 */
public interface Simulator {

    /**
     * Returns the number of choices.
     *
     * @return the number of choices
     */
    int getNumberOfChoices();

    /**
     * pulls the chosen bandit.  If you win (the random number is less than the bandit's value) returns a 1, otherwise
     * returns a 0.
     *
     * @param bandit the bandit to pull
     * @return a 1 if you win, otherwise a 0
     */
    int pull(int bandit);

}
