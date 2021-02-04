public class HardQuestFour {
    public static void main(String[] args) {
        reverse(230);

    }

    public static boolean reverse(int x) {
        String number = String.valueOf(x);
        String newNumber = new StringBuilder(number).reverse().toString();
        if (newNumber.equals(number) ) {
            return true;
        }
        return false;
    }
}
