package de.ait.repositories;

import de.ait.models.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryTextFileImpl implements UsersRepository {

    private String fileName;

    public UsersRepositoryTextFileImpl(String fileName) {
        this.fileName = fileName;
    }

//    @Override
//    public List<User> findAll() {
//        List<User> users = new ArrayList<>(); // делаем список для всех пользователей
//
//        FileReader fileReader = null;
//        BufferedReader bufferedReader = null;
//        try {
//            fileReader = new FileReader(fileName); // открываем файл
//            bufferedReader = new BufferedReader(fileReader); // открываем буферизированный поток для чтения на основе файла
//
//            String line = bufferedReader.readLine(); // считываем строку
//
//            while (line != null) {  // если строку смогли считать
//
//                String[] parsed = line.split("\\|"); // разбиваем строку на составляющие
//                String firstName = parsed[0]; // из каждого кусочка строки делаем отдельную переменную нужного типа
//                String lastName = parsed[1];
//                int age = Integer.parseInt(parsed[2]);
//                double height = Double.parseDouble(parsed[3]);
//
//                User user = new User( // создаем нового пользователя на основе данных из строки
//                        firstName, lastName, age, height
//                );
//                users.add(user); // положили пользователя в список
//                line = bufferedReader.readLine(); // считали следующую строку
//            }
//
//        } catch (IOException e) {
//            System.err.println("Произошла ошибка");
//        } finally { // независимо от того, как сработал код - он будет выполняться в любом случае
//            try {
//                if (fileReader != null) {
//                    fileReader.close();
//                }
//            } catch (IOException ignore) {
//            }
//            try {
//                if (bufferedReader != null) {
//                    bufferedReader.close();
//                }
//                
//            } catch (IOException ignore) {
//            }
//        }
//
//        return users;
//    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>(); // делаем список для всех пользователей

        // try-with-resources
        try (FileReader fileReader = new FileReader(fileName); 
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line = bufferedReader.readLine(); // считываем строку

            while (line != null) {  // если строку смогли считать
                User user = parseLine(line); // преобразуем пользователя в строку
                users.add(user); // положили пользователя в список
                line = bufferedReader.readLine(); // считали следующую строку
            }
        } catch (IOException e) {
            System.err.println("Произошла ошибка");
        }

        return users;
    }

    private static User parseLine(String line) {
        String[] parsed = line.split("\\|"); // разбиваем строку на составляющие
        String firstName = parsed[0]; // из каждого кусочка строки делаем отдельную переменную нужного типа
        String lastName = parsed[1];
        int age = Integer.parseInt(parsed[2]);
        double height = Double.parseDouble(parsed[3]);

        return new User( // создаем нового пользователя на основе данных из строки
                firstName, lastName, age, height
        );
    }
}
