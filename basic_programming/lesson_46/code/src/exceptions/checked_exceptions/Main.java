package checked_exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;

        try {
            FileReader reader = new FileReader("input.txt");
            bufferedReader = new BufferedReader(reader);
        } catch (FileNotFoundException e) {
            System.out.println("Какие-то проблемы - " + e.getMessage());
        }

        try {
            String line = bufferedReader.readLine(); // вызывает ensureOpen() throws IOException
            System.out.println(line);
        } catch (IOException e) {
            System.out.println("Проблемы - " + e.getMessage());
        }

    }
}
