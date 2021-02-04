import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HardQuestTwo {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }

    public static int romanToInt(String s) {
        int sum = 0;
        char[] listChar = s.toCharArray();
        Map<Character, Integer> romanSymbol = new HashMap<>();
        romanSymbol.put('I', 1);
        romanSymbol.put('V', 5);
        romanSymbol.put('X', 10);
        romanSymbol.put('L', 50);
        romanSymbol.put('C', 100);
        romanSymbol.put('D', 500);
        romanSymbol.put('M', 1000);

        for (int i = 0; i < listChar.length; i++) {
            if (i + 1 == listChar.length) {
                sum += romanSymbol.get(listChar[i]);
            } else if (romanSymbol.get(listChar[i]) < romanSymbol.get(listChar[i + 1])) {
                sum += romanSymbol.get(listChar[i + 1]) - romanSymbol.get(listChar[i]);
                i++;
            } else {
                sum += romanSymbol.get(listChar[i]);
            }
        }

        return sum;
    }

}
