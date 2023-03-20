import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        Создайте сканер и получите от пользователя его имя, вес (double), возраст, пол, количество детей, месячный доход.
//
//                Выведите информацию в консоль в следующем формате:
//
//        "Иван Иванов, 37 лет. Пол: мужской.
//        Количество детей: 2. Годовой доход: 55000 евро"
//
//        Обратите внимание, что выводится годовой доход, а не месячный.

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваше имя");
        String name = scanner.nextLine();

        System.out.println("Введите вес");
        double weight = scanner.nextDouble();

        System.out.println("Введите возраст");
        int age = scanner.nextInt();

        System.out.println("Введите пол");
        scanner.nextLine();  // фикс
        String gender = scanner.nextLine();

        System.out.println("Введите число детей");
        int numberOfChildren = scanner.nextInt();

        System.out.println("Введите месячный доход");
        double monthlyIncome = scanner.nextDouble();
        double annualIncome = monthlyIncome * 12;
        System.out.println(name + ", " +
                age + " лет. Пол: " + gender + ".\n"+
                "Вес: "+ weight +
                " Количество детей: " + numberOfChildren +
                " Годовой доход: " + annualIncome + " евро"
        );
    }
}