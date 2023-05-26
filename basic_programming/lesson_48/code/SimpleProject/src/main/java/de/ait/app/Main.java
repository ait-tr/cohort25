package de.ait.app;

import de.ait.repositories.UsersRepository;
import de.ait.repositories.UsersRepositoryListImpl;
import de.ait.repositories.UsersRepositoryTextFileImpl;
import de.ait.services.UsersService;
import de.ait.services.UsersServiceImpl;
import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // компонент, который содержит информацию о файле
        // содержит логику работы с этим файлом - получение всех пользователей
        UsersRepository usersRepository = new UsersRepositoryTextFileImpl("users2.txt");
        UsersRepository testUserRepository = new UsersRepositoryListImpl();
        // компонент, который содержит логику самой программы - получение имен всех пользователей
        UsersService usersService = new UsersServiceImpl(usersRepository);

        while (true) {
            System.out.println("1. Вывести имена всех пользователей");
            System.out.println("2. Вывести фамилию самого взрослого пользователя");

            System.out.println("3. Сохранить нового пользователя"); // с консоли считываете имя фамилию возраст рост и сохраняете в файл
            System.out.println("4. Вывести средний возраст всех пользователей");
            System.out.println("5. Вывести возраст самого высокого человека");
            System.out.println("6. Вывести имя и фамилию самого низкого человека");

            System.out.println("0. Выход");

            int command = scanner.nextInt(); // считываем команду
            scanner.nextLine(); // перейти на новую строку

            switch (command) {
                case 1:
                    System.out.println("Выводим имена пользователей...");
                    // получаем имена всех пользователей через сервис
                    List<String> names = usersService.getNames();
                    // выводим
                    for (String name : names) {
                        System.out.println(name);
                    }

                    break;
                case 2:
                    System.out.println("Выводим самого взрослого пользователя");
                    String lastName = usersService.getLastNameOfMostAging();
                    System.out.println(lastName);

                    break;
                case 0:
                    System.out.println("Выход");
                    System.exit(0);
                default:
                    System.out.println("Команда не распознана");
            }
        }
    }
}
