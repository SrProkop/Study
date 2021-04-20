package thread.cyclist;

import java.util.Date;
import java.util.concurrent.Semaphore;

public class Cyclist extends Thread {

    private Semaphore winners;
    private int speed;
    private long time;

    public Cyclist(String name, Semaphore winners) {
        super(name);
        this.winners = winners;
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

    @Override
    public void run() {
        this.speed = speed()*10;
        Date start = new Date();
        System.out.println("Велосипедист " + Thread.currentThread().getName() + " начал гонку!");
        if (!isInterrupted()) {
            try {
                Thread.sleep(speed);
                winners.acquire();
                Date end = new Date();
                time = (end.getTime() - start.getTime()) / 1000;
                System.out.println("Велосипедист " + Thread.currentThread().getName() + " закончил гонку за " + time + " секунд, заняв " + ((winners.availablePermits() - 5) * -1) + " место");

            } catch (InterruptedException e) {
                System.out.println("Велосепидист " + Thread.currentThread().getName() + " закончил гонку досрочно.");
            }
        }
    }

    public int speed() {
        return (int) (Math.random() * 857) + 545;  //Случайная скорость от 8582мс за 1км(7км в минуту) до 5455мс(11км в минуту) за 1км
    }
}
