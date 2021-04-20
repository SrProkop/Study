package parking.partTwo;

public class Client {

    public static void main(String[] args) {
        AutoParking entry = new AutoParking();
        AutoParking departure = new AutoParking();
        AutoParking autoParking = new AutoParking();
        for (int i = 1; i < 31; i++) {
            new Car(String.valueOf(i), entry, departure, autoParking).start();
        }
    }
}
