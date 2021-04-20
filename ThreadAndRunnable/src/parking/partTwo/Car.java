package parking.partTwo;

public class Car extends Thread{

    private AutoParking entry;
    private AutoParking autoParking;
    private AutoParking departure;

    public Car(String name, AutoParking entry, AutoParking departure, AutoParking autoParking) {
        super(name);
        this.entry = entry;
        this.departure = departure;
        this.autoParking = autoParking;
    }

    @Override
    public void run() {

        synchronized (entry) {
            try {
                boolean access = true;
                while (access) {
                    if (autoParking.getPlaces() < 10) {
                        autoParking.setPlaces(autoParking.getPlaces() + 1);
                        access = false;
                    }
                }
                System.out.println("Автомобиль под номером " + Thread.currentThread().getName() + " заезжает на парковку");
                Thread.sleep(100);
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

        synchronized (departure) {
            try {
                System.out.println("Автомобиль под номером " + Thread.currentThread().getName() + " выезжает с парковки");
                autoParking.setPlaces(autoParking.getPlaces() - 1);
                Thread.sleep(100);
                System.out.println("Автомобиль под номером " + Thread.currentThread().getName() + " уехал");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}