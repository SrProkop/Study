public class HarQuestFive2 {
    public static void main(String[] args) {
        System.out.println(isValid("(([]){})"));
    }

    public static boolean isValid(String s) {
        int x = 0;
        int z = 0;
        char[] arrayChar = s.toCharArray();
        for (int i = 0; i < arrayChar.length; i++) {
            if (40 == (int)arrayChar[i] || 91 == (int)arrayChar[i] || 123 == (int)arrayChar[i]) {
                for (int j = i + 1; j < arrayChar.length; j++) {
                    int comparison = (int)arrayChar[i] - (int)arrayChar[j];
                    if (comparison == 0) {
                        z++;
                    }
                    if (comparison == -1 || comparison == -2) {
                        if ((j - i) % 2 == 1 & 0 == z--) {
                            arrayChar[i] = 0;
                            arrayChar[j] = 0;
                            x++;
                        }
                    } else if (comparison == 40 || comparison == 91 || comparison == 123) {
                        return false;
                    }
                }
            } else if (41 == (int)arrayChar[i] || 93 == (int)arrayChar[i] || 125 == (int)arrayChar[i]) {
                return false;
            }
            if (x == 0) {
                if (40 == (int)arrayChar[i] || 91 == (int)arrayChar[i] || 123 == (int)arrayChar[i]) {
                    System.out.println(i);
                    return false;
                }
            } else {
                x = 0;
            }
            z = 0;
        }
        return true;
    }
}