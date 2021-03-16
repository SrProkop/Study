package thread.cyclist;

public class Cyclist extends Thread {

    public Cyclist(String name) {
        super(name);
    }

    @Override
    public void run() {
        int speed = speed()*10;
        System.out.println("Велосипедист " + Thread.currentThread().getName() + " начал гонку!");
        try {
            Thread.sleep(speed);
        } catch (InterruptedException e) {
            System.out.println("Произошёл сбой...");
            e.printStackTrace();
        }
        System.out.println("Велосипедист " + Thread.currentThread().getName() + " закончил гонку!");
    }

    public int speed() {
        return (int) (Math.random() * 8573) + 5455;  //Случайная скорость от 8582мс за 1км(7км в минуту) до 5455мс(11км в минуту) за 1км
    }
}
