package de.ait.shop;

import de.ait.shop.config.AppConfig;
import de.ait.shop.controllers.UsersController;
import de.ait.shop.repositories.UsersRepository;
import de.ait.shop.services.UsersService;
import de.ait.shop.services.impl.UsersServiceImpl;
import de.ait.shop.validation.EmailValidator;
import de.ait.shop.validation.PasswordValidator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

/**
 * 8/30/2023
 * SimpleApp
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);


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
