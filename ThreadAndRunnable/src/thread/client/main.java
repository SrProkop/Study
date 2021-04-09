package thread.client;

import thread.cyclist.Cyclist;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Cyclist> race = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            race.add(new Cyclist(String.valueOf(i)));
            race.get(i).start();
        }
        boolean endRace = true;
        while (endRace) {
            if (Cyclist.getWinners().size() == 5) {
                for (Cyclist cyclist : race) {
                    boolean isWin = false;
                    for (Cyclist cyclistWinners : Cyclist.getWinners()) {
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
