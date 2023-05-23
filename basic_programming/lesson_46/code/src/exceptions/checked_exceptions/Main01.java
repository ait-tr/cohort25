package checked_exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main01 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = null;

        FileReader reader = new FileReader("input.txt");
        bufferedReader = new BufferedReader(reader);

        String line = bufferedReader.readLine(); // вызывает ensureOpen() throws IOException
        System.out.println(line);
    }
}
