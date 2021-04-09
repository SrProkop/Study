package runnable.cyclist;

import java.util.ArrayList;
import java.util.Date;

public class Cyclist implements Runnable {

    private static volatile ArrayList<Thread> winners = new ArrayList<>();
    private int speed;
    private long time;

    public static ArrayList<Thread> getWinners() {
        return winners;
    }

    public static void setWinners(ArrayList<Thread> winners) {
        Cyclist.winners = winners;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Cyclist() {
    }

    @Override
    public void run() {
        this.speed = speed()*10;
        Date start = new Date();
        System.out.println("Велосипедист " + Thread.currentThread().getName() + " начал гонку!");
        if (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                System.out.println("Велосепидист " + Thread.currentThread().getName() + " закончил гонку досрочно.");
            }
        }
        synchronized (winners) {
            if (winners.size() == 5) {
                return;
            } else {
                Date end = new Date();
                winners.add(Thread.currentThread());
                time = (end.getTime() - start.getTime()) / 1000;
                System.out.println("Велосипедист " + Thread.currentThread().getName() + " закончил гонку за " + time + " секунд, заняв " + winners.size() + " место");
            }
        }
    }

    public int speed() {
        return (int) (Math.random() * 8573) + 5455;  //Случайная скорость от 8582мс за 1км(7км в минуту) до 5455мс(11км в минуту) за 1км
    }
}