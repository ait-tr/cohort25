import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // sout
        System.out.println("Введите ваше имя");
        String name = scanner.nextLine();

        System.out.println("Введите ваш возраст");
        int age = scanner.nextInt();

        System.out.println("Введите город");
        scanner.nextLine();  // фикс - чтобы не съедалась строка
        String city = scanner.nextLine();
        // Jack (г.Берлин), возраст: 25
        System.out.println(
                name + " (г." + city + "), возраст: " + age
        );
        int currentYear = 2023;
        int dateOfBirth = currentYear - age;

        // Здание 2
        // Jack (г.Берлин), возраст: 25
        // Сейчас 2023 год. Год рождения: 1998
        // Верно?

        System.out.println(
                name + " (г." + city + "), возраст: " +
                        age + "\n" + "Сейчас " + currentYear +
                        " год. Год рождения: " + dateOfBirth +
                        "\nВерно?"
        );


    }
}