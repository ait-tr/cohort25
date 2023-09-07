package de.ait.shop.repositories.impl;

import de.ait.shop.models.User;
import de.ait.shop.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 8/23/2023
 * Introduction
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Repository
public class UsersRepositoryFileImpl implements UsersRepository {

    private final String fileName;

    public UsersRepositoryFileImpl(@Value("${users.file-name}") String fileName) {
        this.fileName = fileName;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) { // открываем файл для чтения

            return reader.lines() // получаем все строки из файла
                    .map(line -> line.split("#")) // разбиваем каждую строку на массив из нескольких строк по разделителю
                    .map(parsed -> new User(parsed[0], parsed[1], parsed[2], parsed[3])) // преобразовали в пользователя
                    .collect(Collectors.toList()); // преобразовали в список

        } catch (IOException e)  { // если была ошибка с файлом, сообщаем об этом и останавливаем приложение
            throw new IllegalStateException("Проблемы с чтением из файла: " + e.getMessage());
        }
    }

    @Override
    public void save(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) { // открываем файл для до-записи
            writer.write(user.getFirstName() + "#" + user.getLastName() + "#" + user.getEmail() + "#" + user.getPassword()); // записываем его в файл
            writer.newLine(); // создаем новую строку

        } catch (IOException e) { // если была ошибка с файлом, сообщаем об этом и останавливаем приложение
            throw new IllegalStateException("Проблемы с записью в файл: " + e.getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(User model) {

    }

    @Override
    public User findOneByEmail(String email) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) { // открываем файл для чтения

            return reader.lines() // получаем все строки из файла
                    .map(line -> line.split("#")) // разбиваем каждую строку на массив из нескольких строк по разделителю
                    .filter(parsed -> parsed[1].equals(email)) // находим строку с таким же email
                    .findFirst() // берем первую строку, которая нам подошла
                    .map(parsed -> new User(null, null, null, null)) // преобразовали в пользователя
                    .orElse(null); // возвращаем null если ничего не нашли

        } catch (IOException e)  { // если была ошибка с файлом, сообщаем об этом и останавливаем приложение
            throw new IllegalStateException("Проблемы с чтением из файла: " + e.getMessage());
        }
    }
}
