package examples;

import java.io.BufferedReader;
import java.io.FileReader;

public class MainFileNotFound {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
    }
}
