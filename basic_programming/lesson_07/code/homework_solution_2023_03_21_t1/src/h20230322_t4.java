import java.util.Scanner;

public class h20230322_t4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите предложение");
        String text = scanner.nextLine();
        int mid = text.length() / 2 + text.length() % 2;
        System.out.println(mid);
        System.out.println(text.substring(0, mid));
        System.out.println(text.substring(mid));
        System.out.println(text.length());
        // нога --> до индекса 2 "г" - "но" вторая часть "га"
        // прага --> 5/2 получится 2.5 - но округлятся до 2
        // "пр" "aгa" -- компенсируем используя text.length() % 2
    }
}
