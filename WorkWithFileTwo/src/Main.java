import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) throws Exception{
        File fileXML = new File("typeXml.txt");
        FileReader fileReader = new FileReader(fileXML);
        BufferedReader readerXML = new BufferedReader(fileReader);
        Note note = parseStringForNote(readerXML);
        writerFromJson(note);
    }

    public static Note parseStringForNote(BufferedReader readerXML) throws Exception{
        readerXML.readLine();
        Note note = new Note();
        int numberLine = 0;
        while (readerXML.ready()) {
            String line = readerXML.readLine();
            char[] arrayChar = line.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            boolean access = false;
            for (int i = 0; i < arrayChar.length; i++) {
                if (arrayChar[i] == '<') {
                    access = false;
                }
                if (access) {
                    stringBuilder.append(arrayChar[i]);
                }
                if (arrayChar[i] == '>') {
                    access = true;
                }
            }
            numberLine++;
            switch (numberLine) {
                case 1:
                    note.setTo(stringBuilder.toString());
                    break;
                case 2:
                    note.setFrom(stringBuilder.toString());
                    break;
                case 3:
                    note.setType(stringBuilder.toString());
                    break;
                case 4:
                    note.setBody(stringBuilder.toString());
                    break;
                default:
                    break;
            }

        }
        return note;
    }

    public static void writerFromJson(Note note) throws Exception{
        File fileJson = new File("typeJson.txt");
        if (!fileJson.exists()){
            fileJson.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(fileJson);
        fileWriter.write(note.toString());
        fileWriter.close();
    }
}