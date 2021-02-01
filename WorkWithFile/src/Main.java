import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pathFile = reader.readLine();
        String pathDir = buildPathDir(pathFile);
        File file = new File(pathFile);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String allSymbol = buildListSymbol(bufferedReader);
        createNewFile(pathDir, allSymbol);
    }

    public static String buildPathDir(String pathFile){
        String [] splitPathFile = pathFile.split("\\\\");
        StringBuilder pathDir = new StringBuilder();
        for (int i = 0; i < splitPathFile.length - 1; i++) {
            pathDir.append(splitPathFile[i]);
            pathDir.append('\\');
        }
        return pathDir.toString();
    }

    public static String buildListSymbol(BufferedReader bufferedReader) throws IOException{
        ArrayList<Character> listChar = new ArrayList<>();
        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            char[] arrayChar = line.toCharArray();
            for (int i = 0; i < arrayChar.length; i++) {
                if (listChar.indexOf(arrayChar[i]) == -1) {
                    listChar.add(arrayChar[i]);
                }
            }
        }
        Collections.sort(listChar);
        return listChar.toString();
    }

    public static void createNewFile(String pathDir, String newLine) throws IOException{
        File newFile = new File(pathDir, "newFile.txt");
        if (!newFile.exists()){
            newFile.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(newFile);
        fileWriter.write(newLine);
        fileWriter.close();
    }
}
