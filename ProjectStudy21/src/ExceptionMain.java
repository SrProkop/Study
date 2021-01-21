import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionMain {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        System.out.println(methodOne(line));
    }

    public static int methodOne(String line) {
        try {
            int number = Integer.parseInt(line);
            return number;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

}
