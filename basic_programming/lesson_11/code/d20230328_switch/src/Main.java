/*
пользователь вводит число от 1 до 4
ваша программа должна вывести "один", "два", "три" или "четыре" соответственно.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число от 1 до 4");

        int one = scanner.nextInt();
        if (one>=1 && one<=4) {
            if (one == 1) {    System.out.println("Один");      }
            if (one == 2) {    System.out.println("Два");       }
            if (one == 3) {    System.out.println("Три");       }
            if (one == 4) {    System.out.println("Четыре");    }
        }  else {
            System.out.println("Число введено неверно");
        }

        // решение той же задачи, используя switch...case
        //Работает с целыми числами, строками, char
        // не работает с float и double    1.33   1.3333   1.333333333333333333333333

        switch (one){
            case 1: System.out.println("Один");break;
            case 2: System.out.println("Два");break;
            case 3: System.out.println("Три");break;
            case 4: System.out.println("Четыре");break;
            default: System.out.println("Число введено неверно");
        }

        System.out.println("Введите имя:");
        scanner.nextLine();
        String name = scanner.nextLine();

        switch (name.toLowerCase()){
            case "jack":
                System.out.printf("Привет %s! Давно не заходил%n", name); break;
            case "john":
                System.out.printf("Привет %s!%nКак вчера сходил в кино?%n", name); break;
            case "lena":
                System.out.println("Ура!");
            case "ann":
                System.out.printf("Привет %s! Рад тебя видеть", name); break;
            default:
                System.out.println("Я вас не знаю, но приятно познакомиться! ");
        }
    }
}