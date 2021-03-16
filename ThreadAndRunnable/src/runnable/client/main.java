package runnable.client;

import runnable.cyclist.Cyclist;

public class main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Cyclist(), String.valueOf(i)).start();
        }
    }
}
