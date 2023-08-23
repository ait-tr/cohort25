package de.ait.shop.controllers;

import de.ait.shop.models.User;
import de.ait.shop.services.RegistrationService;
import de.ait.shop.services.impl.RegistrationServiceImpl;

import java.util.Scanner;

/**
 * 8/23/2023
 * Introduction
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class RegistrationController {

    private final Scanner scanner; // поле для считывания данных с консоли с помощью Scanner

    private final RegistrationService registrationService; // зависимость на бизнес-логику регистрации

    public RegistrationController(Scanner scanner, RegistrationService registrationService) { // конструктор, принимающий на вход сервис и Scanner
        this.scanner = scanner;
        this.registrationService = registrationService;
    }

    public void register() { // метод регистрации - обертка над аналогичным методом сервиса, но + считывание данных и их вывод

        // считали необходимые данные

        System.out.println("Введите email");
        String email = scanner.nextLine();

        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        User user = registrationService.register(email , password); // вызвали соответствующий метод сервиса

        System.out.println(user); // вывели результат
    }
}
