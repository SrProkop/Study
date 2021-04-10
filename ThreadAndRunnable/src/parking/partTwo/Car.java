package parking.partTwo;

public class Car extends Thread{

    public Car(String name) {
        super(name);
    }

    @Override
    public void run() {


        synchronized (AutoParking.entry) {
            try {
                boolean bl = true;
                while (bl) {
                    if (AutoParking.autoParking.size() < 10) {
                        bl = false;
                    }
                }
                AutoParking.entry.add(Thread.currentThread());
                System.out.println("Автомобиль под номером " + Thread.currentThread().getName() + " заезжает на парковку");
                Thread.sleep(100);
                AutoParking.entry.remove(Thread.currentThread());
                AutoParking.autoParking.add(Thread.currentThread());
                System.out.println("Автомобиль под номером " + Thread.currentThread().getName() + " встал на парковке");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (AutoParking.departure) {
            try {
                System.out.println("Автомобиль под номером " + Thread.currentThread().getName() + " выезжает с парковки");
                AutoParking.autoParking.remove(Thread.currentThread());
                AutoParking.departure.add(Thread.currentThread());
                Thread.sleep(100);
                AutoParking.departure.remove(Thread.currentThread());
                System.out.println("Автомобиль под номером " + Thread.currentThread().getName() + " уехал");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
