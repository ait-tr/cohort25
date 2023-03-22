import java.util.Scanner;

public class h20230322_t2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите слово");
        String word = scanner.next();
        System.out.println(word.charAt(0));
        System.out.println(word.charAt(1));
        System.out.println(word.charAt(2));
        String partOfWord = word.substring(3);
        System.out.println(partOfWord);
    }
}
