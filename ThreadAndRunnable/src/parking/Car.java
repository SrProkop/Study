package parking;

public class Car extends Thread{

    public Car(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (AutoParking.entry) {
            try {
                AutoParking.entry.add(Thread.currentThread());
                System.out.println("Автомобиль под номером " + Thread.currentThread().getName() + " заезжает на парковку");
                Thread.sleep(100);
                AutoParking.entry.remove(Thread.currentThread());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            AutoParking.autoParking.add(Thread.currentThread());
            System.out.println("Автомобиль под номером " + Thread.currentThread().getName() + " стоит на парковке");
            Thread.sleep(300);
            AutoParking.autoParking.remove(Thread.currentThread());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (AutoParking.departure) {
            try {
                AutoParking.departure.add(Thread.currentThread());
                System.out.println("Автомобиль под номером " + Thread.currentThread().getName() + " выезжает с парковки");
                Thread.sleep(100);
                System.out.println("Автомобиль под номером " + Thread.currentThread().getName() + " уехал");
                AutoParking.departure.remove(Thread.currentThread());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
