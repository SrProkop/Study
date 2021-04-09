package parking;

public class Car extends Thread{

    public Car(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (AutoParking.entry) {
            AutoParking.entry.add(Thread.currentThread());
            try {
                System.out.println("Автомобиль под номером " + Thread.currentThread().getName() + " заезжает на парковку");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            AutoParking.entry.remove(Thread.currentThread());
        }

        AutoParking.autoParking.add(Thread.currentThread());
        try {
            System.out.println("Автомобиль под номером " + Thread.currentThread().getName() + " стоит на парковке");
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AutoParking.autoParking.remove(Thread.currentThread());

        synchronized (AutoParking.departure) {
            AutoParking.departure.add(Thread.currentThread());
            try {
                System.out.println("Автомобиль под номером " + Thread.currentThread().getName() + " выезжает с парковки");
                Thread.sleep(100);
                System.out.println("Автомобиль под номером " + Thread.currentThread().getName() + " уехал");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            AutoParking.departure.remove(Thread.currentThread());
        }
    }
}
