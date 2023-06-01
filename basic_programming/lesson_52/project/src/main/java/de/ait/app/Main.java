package de.ait.app;

import de.ait.repositories.UsersRepository;
import de.ait.repositories.UsersRepositoryListImpl;
import de.ait.repositories.UsersRepositoryTextFileImpl;
import de.ait.services.UsersService;
import de.ait.services.UsersServiceImpl;


import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsersRepository usersRepository = new UsersRepositoryTextFileImpl("users.txt");
        UsersRepository testUserRepository = new UsersRepositoryListImpl();
        UsersService usersService = new UsersServiceImpl(usersRepository);


        while (true) {
            System.out.println("1. Вывести имена всех пользователей");
            System.out.println("2. Вывести фамилию самого взрослого пользователя");
            System.out.println("3. Сохранить нового пользователя");
            System.out.println("4. Вывести средний возраст всех пользователей");
            System.out.println("5. Вывести возраст самого высокого человека");
            System.out.println("6. Вывести имя и фамилию самого низкого человека");
            System.out.println("0. Выход");

            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1 -> {
                    System.out.println("Выводим имена пользователей...");
                    List<String> names = usersService.getNames();
                    for (String name : names) {
                        System.out.println(name);
                    }
                }
                case 2 -> {
                    System.out.println("Выводим самого взрослого пользователя");
                    String lastName = usersService.getLastNameOfMostAging();
                    System.out.println(lastName);
                }
                case 3 -> {
                    System.out.println("Сохранить нового пользователя");
                    System.out.println("Введите имя");
                    String firstName = scanner.nextLine();
                    System.out.println("Введите фамилию");
                    String secondName = scanner.nextLine();
                    System.out.println("Введите возраст");
                    int age = Integer.parseInt(scanner.nextLine());
                    System.out.println("Введите рост");
                    double height = Double.parseDouble(scanner.nextLine());
                    usersService.createNewUser(firstName, secondName, age, height);
                }
                case 4 -> {
                    System.out.println("Выводим средний возраст всех пользователей");
                    double averageAge = usersService.getAverageAge();
                    System.out.printf("%.2f"+ System.lineSeparator(),averageAge);

                }
                case 5 -> {
                    System.out.println("Выводим возраст самого высокого человека");
                    int tallestAge = usersService.getAgeOfTallestPerson();
                    System.out.println(tallestAge);
                }
                case 6 -> {
                    System.out.println("Выводим имя и фамилию самого низкого пользователя");
                    String fullNameOfShortest = usersService.getFullNameOfShortest();
                    System.out.println(fullNameOfShortest);
                }
                case 0 -> {
                    System.out.println("Выход");
                    System.exit(0);
                }
                default -> System.out.println("Команда не распознана");
            }
        }
    }
}
