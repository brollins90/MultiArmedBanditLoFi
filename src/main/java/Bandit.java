import java.util.Random;

/**
 * Created by brollins on 10/15/2015.
 */
public class Bandit {

    Random random;

    int pullCount;
    int winCount;
    double winProbability;

    public Bandit(Random random) {
        this.random = random;
        this.pullCount = 0;
        this.winCount = 0;
        this.winProbability = random.nextDouble();
    }

    public int getPullCount() {
        return pullCount;
    }

    public int getWinCount() {
        return winCount;
    }

    public double getWinProbability() {
        return winProbability;
    }

    /**
     * Pulls the bandit and increases the statistics.
     * @return returns true if you won (the random value is less than the win probability), otherwise false
     */
    public boolean pull() {

        double thisRandom = random.nextDouble();
        boolean won = thisRandom < winProbability;

        pullCount++;
        if (won) winCount++;
        return won;
    }

    @Override
    public String toString() {
        return "Bandit{" +
                "pullCount=" + pullCount +
                ", winCount=" + winCount +
                ", winProbability=" + winProbability +
                '}';
    }
}
