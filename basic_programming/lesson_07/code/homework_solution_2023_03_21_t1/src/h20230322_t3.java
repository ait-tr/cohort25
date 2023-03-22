import java.util.Scanner;

public class h20230322_t3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите слово");
        String word = scanner.next();
        int length = word.length();
        String partOfWord = word.substring(0, length - 3);
        System.out.println(partOfWord);
        System.out.println(word.charAt(length - 3));
        System.out.println(word.charAt(length - 2));
        System.out.println(word.charAt(word.length() - 1)); // можно без переменной
    }
}
