package repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// читает слова из файла
public class WordsRepository {

    private String fileName; // название файла из которого будем читать

    public WordsRepository(String fileName) { // конструктор, куда передаем название файла
        this.fileName = fileName;
    }

    public String readWord() { // метод для чтения слова из файла
        try {
            FileReader fileReader = new FileReader(fileName); // выбрасывает
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String word = bufferedReader.readLine(); // выбрасывает исключение
            return word;
        } catch (IOException e) {
            System.err.println("Проблемы в системе");
            // записать в какой-нибудь файл саму ошибку
            // отправить по почте системному администратору
            return "";
        }
    }
}
