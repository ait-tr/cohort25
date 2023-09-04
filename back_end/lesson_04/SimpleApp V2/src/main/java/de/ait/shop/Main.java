package de.ait.shop;

import de.ait.shop.config.AppConfig;
import de.ait.shop.controllers.UsersController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

/**
 * 8/30/2023
 * SimpleApp
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        Scanner scanner = applicationContext.getBean(Scanner.class);
        UsersController usersController = applicationContext.getBean(UsersController.class);

        boolean isRun = true;

        while (isRun) {
            String command = scanner.nextLine(); // считываем команду

            switch (command) {
                case "/addUser" ->  // если это команда на регистрацию
                        usersController.addUser(); // регистрируем пользователя
                case "/users" ->  // если это команда на получение пользователей
                        usersController.getAllUsers();
                case "/users/update" -> // если это команда на обновление пользователя
                        usersController.updateUser();
                case "/exit" -> isRun = false;
            }
        }
    }
}
