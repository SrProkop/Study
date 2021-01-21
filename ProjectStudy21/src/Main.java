import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        char [] listChar = line.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char symbol : listChar) {
            if (hashMap.size() == 0) {
                hashMap.put(symbol, 0);
            }
            if (hashMap.containsKey(symbol)) {
                int count = hashMap.get(symbol) + 1;
                hashMap.remove(symbol);
                hashMap.put(symbol, count);
            } else {
                hashMap.put(symbol, 1);
            }
            }
        hashMap.forEach((k, v) -> System.out.println(k + " = " + v));
        }
}