package try_catch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) {
        Scanner scanner = null;

        while (true) {
            try {
                int a = scanner.nextInt(); // Hello
                int b = scanner.nextInt();
                int c = a / b;
                System.out.println(c);
            } catch (NullPointerException e) { // обрабатывается отдельно
                scanner = new Scanner(System.in);
            } catch (Exception e) { // все остальные ошибки отдельно
                System.out.println("Ошибка - " + e.getMessage());
                System.out.println("Введите числа заново!");
                scanner.nextLine();
            }
        }
    }
}
