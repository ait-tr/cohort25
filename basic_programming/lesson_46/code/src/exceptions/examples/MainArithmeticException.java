package examples;

import java.util.Scanner;

public class MainArithmeticException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int c = a / b;
        System.out.println(c);
    }
}