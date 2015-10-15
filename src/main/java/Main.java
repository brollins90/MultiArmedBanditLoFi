/**
 * Created by brollins on 10/15/2015.
 */
public class Main {

    public static void main (String[] args) {

        Simulator simulator = new BanditSimulator(3);
        System.out.println(simulator.pull(1));

        System.out.println(simulator);
    }
}
