package parking.partOne;

public class Car extends Thread{

    private AutoParking entry;
    private AutoParking departure;

    public Car(String name, AutoParking entry, AutoParking departure) {
        super(name);
        this.entry = entry;
        this.departure = departure;
    }

    @Override
    public void run() {
        synchronized (entry) {
            try {
                System.out.println("Автомобиль под номером " + Thread.currentThread().getName() + " заезжает на парковку");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            System.out.println("Автомобиль под номером " + Thread.currentThread().getName() + " стоит на парковке");
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (departure) {
            try {
                System.out.println("Автомобиль под номером " + Thread.currentThread().getName() + " выезжает с парковки");
                Thread.sleep(100);
                System.out.println("Автомобиль под номером " + Thread.currentThread().getName() + " уехал");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
