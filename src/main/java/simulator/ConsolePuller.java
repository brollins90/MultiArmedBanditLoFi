package simulator;

import java.util.Scanner;

/**
 * Created by brollins on 10/15/2015.
 */
public class ConsolePuller implements Puller {

    Simulator simulator;

    public ConsolePuller(Simulator simulator) {
        this.simulator = simulator;
    }

    public void pull(int numberOfPulls) {

        int numChoices = simulator.getNumberOfChoices();
        int choice;

        for (int i = 0; i < numberOfPulls; i++) {
            choice = getChoiceFromConsole(numChoices);
            int won = simulator.pull(choice);
            if (won == 0) {
                System.out.println("You lost");
            } else {
                System.out.println("You won");
            }
        }
    }

    private int getChoiceFromConsole(int numChoices) {
        boolean valid = false;
        int choice = 0;

        Scanner in = new Scanner(System.in);

        while (!valid) {
            try {

                System.out.println("Choose a pull between 0 and " + (numChoices - 1));
                choice = in.nextInt();
                if (choice > -1 && choice < numChoices - 1) {
                    valid = true;
                }
            } catch (Exception e) {

            }
        }
        return choice;
    }
}
