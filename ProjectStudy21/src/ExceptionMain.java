import MyException.*;

public class ExceptionMain {

    public static void main(String[] args) {
        String line = "23f";
        int numberOverHundred = 500;
        int numberLessHundred = 50;
        methodOne(line);

        try {
            myCheckedException(numberOverHundred);
        } catch (NumberIsOverHundredException e) {
            System.out.println(e);
        }

        try {
            myUncheckedException(numberLessHundred);
        } catch (NumberIsLessHundredException e) {
            System.out.println(e);
        }
    }

    public static int methodOne(String line) {
        try {
            int number = Integer.parseInt(line);
            return number;
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        return 0;
    }

    public static void myCheckedException(int number) throws NumberIsOverHundredException {
        if (number <= 100) {
            System.out.println("Число: " + number);
        } else {
            throw new NumberIsOverHundredException("Число: " + number + " больше 100");
        }
    }

    public static void myUncheckedException(int number) throws NumberIsLessHundredException {
        if (number >= 100) {
            System.out.println("Число: " + number);
        } else {
            throw new NumberIsLessHundredException("Число: " + number + " меньше 100");
        }
    }
}
