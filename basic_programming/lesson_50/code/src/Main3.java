import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = {-100, -1, 3, 10, 13, 15, 34, 45};
        int number = scanner.nextInt();
        // хотя бы определить, оно в левой части или в правой
        int middle = a.length / 2; // 4
        System.out.println(a[middle]);

        if (number < a[middle]) {
            System.out.println("Число слева");
        } else if (number > a[middle]) {
            System.out.println("Число справа");
        } else {
            System.out.println("Число по центру");
        }

    }
}
