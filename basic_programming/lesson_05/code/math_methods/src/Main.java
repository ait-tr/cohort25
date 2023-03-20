import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x = 7;
        int z = 8;
        long l = 8788L;
        double y = 89.2;
        int sum = x + z;   // если складываем два int
        // если складываем int и double - будет значение типа double
        double sum2 = x + y;
        // если поделю  int на int
        int dev = x / z;
        System.out.println(dev); // отбросилась дробная часть
        // если поделю  int на int - но сохраню результат в double
        double dev2 = x / z;
        System.out.println(dev2); // не работает
        // Вывод - если хотим, чтобы деление работало,
        // нужно иметь хотя бы один множитель должен быть double
        double d = 10;
        double dev3 = x / d;
        System.out.println(dev3);  // ура,  0.7
        //
        System.out.println(7 / 3); // 2
        System.out.println(7 / 3.0); // 2.3333333333333335
        // Повторим математические операции: +, -, *, /, %
        // % - целочисленное деление - оператор
        int reminder = 7 % 3;
        // 4 % 3 = одна целая тройка, а *** результат единица  ***
        // 5 % 3 = одна целая тройка, а *** результат двойка   ***
        // 6 % 3 = две целых тройки,  а *** результат ноль     ***
        // 7 % 3 = две целых тройки,  а *** результат единица  ***

        System.out.println(reminder);
        int reminder2 = 1 % 3;
        // 1 % 3 = ноль целых троек,  а *** результат единица  ***
        System.out.println(reminder2);

        // Где это можно использовать?
        // - мы можем посмотреть кратно ли число другому числ.
        // - Одно число кратно другому - когда делится на него без остатка.
        System.out.println(12 % 4); // 0 - значит кратно четырем
        System.out.println(12 % 5); // 2 - значит не кратно, потому что не ноль
        // - является ли четным?
        System.out.println(12 % 2); // 0 - значит число четное
        System.out.println(13 % 2); // 1 - значит не четное, потому что не ноль

        System.out.println("***********************");
        // java.land.Math // в нем есть удобные мотоды
        // возведение в степень      // power - степень
        double m1 = Math.pow(3, 2);  // 3 во второй степени
        System.out.println(m1);      // 9

        // округление до ближайшего
        double m2 = Math.round(5.7);
        System.out.println(m2);      // 6

        // округление до меньшего    // floor переводится как пол
        double m3 = Math.floor(5.8);
        System.out.println(m3);      // 5

        // округление до большего    // ceiling переводится как потолок
        double m4 = Math.ceil(7.1);
        System.out.println(m4);      // 8

        // квадратный корень         // square root
        double m5 = Math.sqrt(9);

        // Math.cbrt(9); - кубический корень - если кому-то нужен
        System.out.println(m5);      // 3

        // Напишите программу, которая просит у пользователя ввести
        // площадь квадрата, а выводит в консоль размер его стороны.
        // Округлите результат до большего.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите площадь квадрата");
        double squareArea = scanner.nextDouble();
        double sideLength = Math.sqrt(squareArea);
        double ceiledSideLength = Math.ceil(sideLength);
        System.out.println(ceiledSideLength);

    }
}