package parking.semaphore;

import java.util.concurrent.Semaphore;

public class Client {

    public static void main(String[] args) {
        Semaphore entry = new Semaphore(1, true);
        Semaphore stay = new Semaphore(10, true);
        Semaphore departure = new Semaphore(1, true);
        for (int i = 1; i < 31; i++) {
            new Car(String.valueOf(i), entry, stay, departure).start();
        }
    }
}
