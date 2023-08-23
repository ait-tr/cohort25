package de.ait.shop;

import de.ait.shop.controllers.UsersController;
import de.ait.shop.repositories.UsersRepository;
import de.ait.shop.repositories.impl.UsersRepositoryFileImpl;
import de.ait.shop.repositories.impl.UsersRepositoryListImpl;
import de.ait.shop.services.UsersService;
import de.ait.shop.services.impl.UsersServiceImpl;

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
        UsersRepository usersRepositoryList = new UsersRepositoryListImpl(); // создаем репозиторий
        UsersRepository usersRepositoryFile = new UsersRepositoryFileImpl("users.txt");
        UsersService usersService = new UsersServiceImpl(usersRepositoryFile); // создаем сервис с зависимостью на репозиторий
        UsersController usersController = new UsersController(scanner, usersService); // создаем контроллер с зависимостью на Scanner и сервис

        boolean isRun = true;

        while (isRun) {
            String command = scanner.nextLine(); // считываем команду

            switch (command) {
                case "/addUser" ->  // если это команда на регистрацию
                        usersController.addUser(); // регистрируем пользователя
                case "/users" ->  // если это команда на получение пользователей
                        usersController.getAllUsers();
                case "/exit" -> isRun = false;
            }
        }
    }
}
