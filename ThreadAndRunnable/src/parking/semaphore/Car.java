package parking.semaphore;

import java.util.concurrent.Semaphore;

public class Car extends Thread{

    private final Semaphore entry;
    private final Semaphore stay;
    private final Semaphore departure;

    public Car(String name, Semaphore entry, Semaphore stay, Semaphore departure) {
        super(name);
        this.entry = entry;
        this.stay = stay;
        this.departure = departure;
    }

    @Override
    public void run() {

        try {
            stay.acquire();
            entry.acquire();
            System.out.println("Автомобиль под номером " + Thread.currentThread().getName() + " заезжает на парковку");
            sleep(100);
            System.out.println("Автомобиль под номером " + Thread.currentThread().getName() + " заехал на парковку");
            entry.release();
            System.out.println("Автомобиль под номером " + Thread.currentThread().getName() + " встал на парковке");
            sleep(300);
            System.out.println("Автомобиль под номером " + Thread.currentThread().getName() + " закончил стоять и едет к выходу");
            stay.release();
            departure.acquire();
            System.out.println("Автомобиль под номером " + Thread.currentThread().getName() + " выезжает с парковки");
            sleep(100);
            System.out.println("Автомобиль под номером " + Thread.currentThread().getName() + " уехал");
            departure.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}