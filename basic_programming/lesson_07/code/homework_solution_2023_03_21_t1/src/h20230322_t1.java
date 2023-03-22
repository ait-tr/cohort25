import java.util.Scanner;

public class h20230322_t1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите слово");
        String word = scanner.next();
        System.out.println("Слово: \"" + word + "\"");
        int numberOfCharacters = word.length();
        System.out.println("Количество букв: " + numberOfCharacters);
        char firstSymbol = word.charAt(0);
        char lastSymbol = word.charAt(word.length() - 1);
        System.out.println("Начинается на: " + firstSymbol);
        System.out.println("Заканчивается на: "+ lastSymbol);
    }
}
