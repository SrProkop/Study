package parking.partOne;

public class Client {

    public static void main(String[] args) {
        AutoParking entry = new AutoParking();
        AutoParking departure = new AutoParking();
        for (int i = 1; i < 31; i++) {
            new Car(String.valueOf(i), entry, departure).start();
        }
    }
}
