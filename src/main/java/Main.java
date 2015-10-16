import bandit.BanditSimulator;
import bandit.BayesianPuller;
import simulator.ConsolePuller;
import simulator.Puller;
import simulator.RandomPuller;
import simulator.Simulator;

/**
 * Created by brollins on 10/15/2015.
 */
public class Main {

    public static void main(String[] args) {

        Simulator simulator = new BanditSimulator(3);
//        Puller puller = new ConsolePuller(simulator);
//        Puller puller = new RandomPuller(simulator);
        Puller puller = new BayesianPuller(simulator);

        puller.pull(50);
        ((BayesianPuller) puller).setExploitMode();
        puller.pull(50);

        System.out.println(simulator);
    }
}
