package runnable.client;

import runnable.cyclist.Cyclist;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Thread> race = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            race.add(new Thread(new Cyclist(), String.valueOf(i)));
            race.get(i).start();
        }

        boolean endRace = true;
        while (endRace) {
            if (Cyclist.getWinners().size() == 5) {
                for (Thread cyclist : race) {
                    boolean isWin = false;
                    for (Thread cyclistWinners : Cyclist.getWinners()) {
                        if (cyclist.equals(cyclistWinners)) {
                            isWin = true;
                        }
                        if (!isWin) {
                            cyclist.interrupt();
                        }
                    }
                }
                endRace = false;
            }
        }
    }
}
