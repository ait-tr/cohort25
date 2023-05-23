package try_catch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = null;

        while (true) {
            try {
                int a = scanner.nextInt(); // Hello
                int b = scanner.nextInt();
                int c = a / b;
                System.out.println(c);
            } catch (ArithmeticException e) {
                System.out.println("Ошибка - " + e.getMessage());
                System.out.println("Введите числа заново!");
            } catch (InputMismatchException e) {
                System.out.println("Ввели не числа! Исправьтесь");
                scanner.nextLine(); // переходим на новую строку
            } catch (NullPointerException e) {
                scanner = new Scanner(System.in);
            }
        }


    }
}
