package de.ait.shop;

import de.ait.shop.controllers.RegistrationController;
import de.ait.shop.repositories.UsersRepository;
import de.ait.shop.repositories.impl.UsersRepositoryListImpl;
import de.ait.shop.services.RegistrationService;
import de.ait.shop.services.impl.RegistrationServiceImpl;

import java.util.Scanner;

/**
 * 8/23/2023
 * Introduction
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // создаем Scanner для считывания с консоли
        UsersRepository usersRepository = new UsersRepositoryListImpl(); // создаем репозиторий
        RegistrationService registrationService = new RegistrationServiceImpl(usersRepository); // создаем сервис с зависимостью на репозиторий
        RegistrationController registrationController = new RegistrationController(scanner, registrationService); // создаем контроллер с зависимостью на Scanner и сервис

        while (true) {
            String command = scanner.nextLine(); // считываем команду

            if (command.equals("/register")) { // если это команда на регистрацию
                registrationController.register(); // регистрируем пользователя
            } else if (command.equals("/exit")) {
                break;
            }
        }
    }
}
