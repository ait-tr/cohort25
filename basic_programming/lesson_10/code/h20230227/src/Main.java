import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Выбираем любую тему.
        // Панды
        // 1. Сколько зубов у панды?
        //  если пользователь вводит 38 - "Правильный ответ"
        //  если вводит неправильный ответ:
        // - "Неправильный ответ"

        // дополнительно *
        // если вводит неправильный ответ:
        // "Неверно, правильный ответ: <правильный ответ>"

        // дополнительно *
        // Чтобы в конце выводился подсчет очков
        // "Правильно отвечено на 3 из 5 вопросов"

        // дополнительно **
        // добавить вторую попытку ответа
        // answer.equals("мяч")
        int score = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько бит в байте?");
        String rightAnswer1 = "8";
        String answer1 = scanner.nextLine();
        if (rightAnswer1.equals(answer1)){
            System.out.println("Правильно");
            score = score + 1;
        } else {
            System.out.println("Попробуйте еще раз");
            answer1 = scanner.nextLine();
            if(answer1.equals(rightAnswer1)){
                System.out.println("Правильно");
                score = score + 1;
            } else {
            System.out.println("Это неправильный ответ");
            System.out.println("Правильный ответ:"+ rightAnswer1);
            }
        }
        System.out.println("Сколько примитивных типов в Java?");
        String rightAnswer2 = "8";
        String answer2 = scanner.nextLine();
        if (rightAnswer2.equals(answer2)){
            System.out.println("Правильно");
            score = score + 1;
        } else {
            System.out.println("Это неправильный ответ");
            System.out.println("Правильный ответ:"+ rightAnswer2);
        }
        System.out.println("Общий счет: " + score);
    }
}