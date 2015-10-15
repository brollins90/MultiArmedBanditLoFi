import bandit.BanditSimulator;
import bandit.RandomPuller;
import simulator.Puller;
import simulator.Simulator;

/**
 * Created by brollins on 10/15/2015.
 */
public class Main {

    public static void main (String[] args) {

        Simulator simulator = new BanditSimulator(3);
        Puller puller = new RandomPuller(simulator);

        puller.pull(5);

        System.out.println(simulator);
    }
}
