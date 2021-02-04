public class HardQuestFive {
    public static void main(String[] args) {
        System.out.println(isValid("[({])}"));
    }

    public static boolean isValid(String s) {
        if (s.length() == 1) {
            return false;
        }
        int x = 0;
        int y = 0;
        char[] arrayChar = s.toCharArray();
        for (int i = 0; i < arrayChar.length; i++) {
            for (int j = i + 1; j < arrayChar.length; j++) {
                if ('(' == arrayChar[i] && ')' == arrayChar[j]) {
                    if ((j - i) % 2 == 0) {
                        return false;
                    }
                    arrayChar[i] = 0;
                    arrayChar[j] = 0;
                    x++;
                }
                if ('{' == arrayChar[i] && '}' == arrayChar[j]) {
                    if ((j - i) % 2 == 0) {
                        return false;
                    }
                    arrayChar[i] = 0;
                    arrayChar[j] = 0;
                    x++;
                }
                if ('[' == arrayChar[i] && ']' == arrayChar[j]) {
                    if ((j - i) % 2 == 0) {
                        return false;
                    }
                    arrayChar[i] = 0;
                    arrayChar[j] = 0;
                    x++;
                }
            }
            if (x == y && arrayChar[i] != 0) {
                return false;
            } else {
                x = y;
            }

        }
        return true;
    }
}
