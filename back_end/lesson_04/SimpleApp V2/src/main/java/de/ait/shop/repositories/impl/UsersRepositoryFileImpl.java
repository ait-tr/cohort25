package de.ait.shop.repositories.impl;

import de.ait.shop.models.User;
import de.ait.shop.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
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

    private Long generatedId = 1L;

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) { // открываем файл для чтения

            return reader.lines() // получаем все строки из файла
                    .map(line -> line.split("#")) // разбиваем каждую строку на массив из нескольких строк по разделителю
                    .map(parsed -> new User(Long.parseLong(parsed[0]), parsed[1], parsed[2])) // преобразовали в пользователя
                    .collect(Collectors.toList()); // преобразовали в список

        } catch (IOException e)  { // если была ошибка с файлом, сообщаем об этом и останавливаем приложение
            throw new IllegalStateException("Проблемы с чтением из файла: " + e.getMessage());
        }
    }

    @Override
    public void save(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) { // открываем файл для до-записи

            user.setId(generatedId); // присваиваем id пользователю

            writer.write(user.getId() + "#" + user.getEmail() + "#" + user.getPassword()); // записываем его в файл
            writer.newLine(); // создаем новую строку

        } catch (IOException e) { // если была ошибка с файлом, сообщаем об этом и останавливаем приложение
            throw new IllegalStateException("Проблемы с записью в файл: " + e.getMessage());
        }
        // если до этого все прошло хорошо - генерируем новый id, который присвоим следующему пользователю
        generatedId++;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(User model) {
        // на вход получили пользователя, нужно его перезаписать в файле
        // нюанс - нельзя переписать одну строку в файле, нужно переписывать полностью.
        // Надо заново прочитать весь файл, туда положить нашего пользователя и потом файл перезаписать.
        List<User> users = findAll(); // получили всех пользователей из файла
        // удалим оттуда пользователя, который имеет старые данные
        for (int i = 0; i < users.size(); i++) { // пробегаем всех пользователей
            if (users.get(i).getId().equals(model.getId())) {
                // если нашли пользователя, которого будем обновлять
                users.remove(i); // удаляем из списка
                break; // останавливаем цикл
            }
        }
        // обновленного пользователя кладем в список
        users.add(model);
        // нужно просто записать список в файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){

            for (User user : users) {
                writer.write(user.getId() + "#" + user.getEmail() + "#" + user.getPassword()); // записываем его в файл
                writer.newLine(); // создаем новую строку
            }

        } catch (IOException e) {
            throw new IllegalStateException("Проблемы с записью в файл: " + e.getMessage());
        }
    }

    @Override
    public User findOneByEmail(String email) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) { // открываем файл для чтения

            return reader.lines() // получаем все строки из файла
                    .map(line -> line.split("#")) // разбиваем каждую строку на массив из нескольких строк по разделителю
                    .filter(parsed -> parsed[1].equals(email)) // находим строку с таким же email
                    .findFirst() // берем первую строку, которая нам подошла
                    .map(parsed -> new User(Long.parseLong(parsed[0]), parsed[1], parsed[2])) // преобразовали в пользователя
                    .orElse(null); // возвращаем null если ничего не нашли

        } catch (IOException e)  { // если была ошибка с файлом, сообщаем об этом и останавливаем приложение
            throw new IllegalStateException("Проблемы с чтением из файла: " + e.getMessage());
        }
    }
}
