package thread.cyclist;

import java.util.ArrayList;
import java.util.Date;

public class Cyclist extends Thread {

    private static volatile ArrayList<Cyclist> winners = new ArrayList<>();
    private int speed;
    private long time;

    public Cyclist(String name) {
        super(name);
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

    public static ArrayList<Cyclist> getWinners() {
        return winners;
    }

    public static void setWinners(ArrayList<Cyclist> winners) {
        Cyclist.winners = winners;
    }

    @Override
    public void run() {
        this.speed = speed()*10;
        Date start = new Date();
        System.out.println("Велосипедист " + Thread.currentThread().getName() + " начал гонку!");
        if (!isInterrupted()) {
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
                winners.add(this);
                time = (end.getTime() - start.getTime()) / 1000;
                System.out.println("Велосипедист " + Thread.currentThread().getName() + " закончил гонку за " + time + " секунд, заняв " + winners.size() + " место");
            }
        }
    }

    public int speed() {
        return (int) (Math.random() * 8573) + 5455;  //Случайная скорость от 8582мс за 1км(7км в минуту) до 5455мс(11км в минуту) за 1км
    }
}
