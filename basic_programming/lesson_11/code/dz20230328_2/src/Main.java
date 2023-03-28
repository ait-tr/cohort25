import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*Задача 2
        Написать программу, которая спрашивает у пользователя его настроение, дальше два варианта:
        если ответ был "хорошо": выводит в консоль "Рад за тебя".
        если ответ был любой другой: спрашивает: "Но ты же оптимистично настроен?"
        если ответ на второй вопрос: да - выводит "Так держать"
        если ответ на второй вопрос любой другой - выводит "Не кисни"
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Какое у Вас настроение?");
        String nastroy = scanner.nextLine();

        boolean moodOk = nastroy.equalsIgnoreCase("Хорошо");

        if (moodOk) {
            System.out.println("Рад за тебя!");
        } else {
            System.out.println("Но ты же оптимистично настроен?");
            String answer = scanner.nextLine();
            boolean ok1 = answer.equalsIgnoreCase("Да");
            if (ok1) {
                System.out.println("Так держать!");
            } else {
                System.out.println("Не кисни!");
            }
        }
    }
}
