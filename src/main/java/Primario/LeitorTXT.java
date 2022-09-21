package Primario;

import java.io.*;
import java.util.ArrayList;

class LeitorTXT {
    private static String filePath;

    LeitorTXT(String filePath) {
        this.filePath = filePath;
    }

    static ArrayList<String> read() {
        File file = new File(filePath);
        String string;
        ArrayList<String> linhas = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while ((string = bufferedReader.readLine()) != null) {
                linhas.add(string);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("exception occurred");
        }

        return linhas;
    }
}
