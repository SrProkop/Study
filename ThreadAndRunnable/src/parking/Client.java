package parking;

public class Client {

    public static void main(String[] args) {
        for (int i = 1; i < 31; i++) {
            new Car(String.valueOf(i)).start();
        }
    }
}
