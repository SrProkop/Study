package runnable.client;

import runnable.cyclist.Cyclist;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class main {
    public static void main(String[] args) {
        List<Thread> race = new ArrayList<>();
        Semaphore winners = new Semaphore(5);
        for (int i = 0; i < 10; i++) {
            race.add(new Thread(new Cyclist(winners), String.valueOf(i)));
            race.get(i).start();
        }

        boolean endRace = true;
        while (endRace) {
            if (winners.availablePermits() == 0) {
                for (Thread cyclist : race) {
                    if (cyclist.isAlive()) {
                        cyclist.interrupt();
                    }
                }
                endRace = false;
            }
        }
    }
}
