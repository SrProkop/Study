package thread.client;

import thread.cyclist.Cyclist;

public class main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Cyclist(String.valueOf(i)).start();
        }
    }
}
