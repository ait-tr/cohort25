package de.ait.shop.controllers;

import de.ait.shop.models.User;
import de.ait.shop.services.UsersService;

import java.util.List;
import java.util.Scanner;

/**
 * 8/23/2023
 * Introduction
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class UsersController {

    private final Scanner scanner; // поле для считывания данных с консоли с помощью Scanner

    private final UsersService usersService; // зависимость на бизнес-логику регистрации

    public UsersController(Scanner scanner, UsersService usersService) { // конструктор, принимающий на вход сервис и Scanner
        this.scanner = scanner;
        this.usersService = usersService;
    }

    public void addUser() { // метод регистрации - обертка над аналогичным методом сервиса, но + считывание данных и их вывод

        // считали необходимые данные

        System.out.println("Введите email");
        String email = scanner.nextLine();

        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        User user = usersService.addUser(email , password); // вызвали соответствующий метод сервиса

        System.out.println(user); // вывели результат
    }

    public void getAllUsers() { // метод для получения всех пользователей
        List<User> users = usersService.getAllUsers(); // запрашиваем у бизнес-логики всех пользователей

        System.out.println(users); // выводим в консоль
    }
}
