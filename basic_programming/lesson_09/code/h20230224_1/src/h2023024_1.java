import java.util.Scanner;

public class h2023024_1 {
    public static void main(String[] args) {
//        Есть прибор у которого есть 2 колбы. В программе дано две переменных,
//                которые содержат температуру каждой колбы (значение для этих переменных можно задат со Scanner, можно просто присвоить значение в программе ).
//        Считается, что прибор работает корректно  если разница температуры между кобами не более 10 градусов и в одной из колб (в любой из двух) температура больше 70 градусов.
//                Если хотите, можно немного упростить: считать, что температура в первой колбе всегда больше, чем температура во второй
//
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите температуру первой колбы");
        double temperatureOfFirst = scanner.nextDouble();
        System.out.println("Введите температуру второй колбы");
        double temperatureOfSecond = scanner.nextDouble();
        // если разница температуры между колбами не более 10 градусов
        // Math.abs - метод - модуль - возвращает абсолютное значение  - без минуса
        double difference = Math.abs(temperatureOfFirst - temperatureOfSecond);
        boolean condition1 = difference <= 10;
        // и в одной из колб (в любой из двух) температура больше 70 градусов
        boolean condition2 = temperatureOfFirst > 70 || temperatureOfSecond > 70;
        // теперь объединим -
        if (condition1 && condition2) {
            System.out.println("Работает корректно");
        } else {
            System.out.println("Работает не корректно");
        }

    }
}
