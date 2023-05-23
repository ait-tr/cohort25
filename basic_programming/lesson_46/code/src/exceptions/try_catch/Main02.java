package try_catch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner scanner = null;

        while (true) {
            try {
                int a = scanner.nextInt(); // Hello
                int b = scanner.nextInt();
                int c = a / b;
                System.out.println(c);
            } catch (ArithmeticException | InputMismatchException e) {
                System.out.println("Ошибка - " + e.getMessage());
                System.out.println("Введите числа заново!");
                scanner.nextLine();
            }  catch (NullPointerException e) {
                scanner = new Scanner(System.in);
            }
        }
    }
}
