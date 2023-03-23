import java.util.Scanner;

public class Main {
    /*
    Задание 2

Пользователь вводит слово, если слово не начинается на букву ‘Q’, выведите в консоль фразу: «А я уже начал бояться”, в противном случае - «Не повезло».
Сохраните результат проверки условия в переменную типа boolean и выведите ее в консоль.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите слоово: ");
        String word = scanner.nextLine();
        char first=word.charAt(0); // первый символ в строке word
        first='Q';
        boolean answer= first!='Q';
        if (answer){
            System.out.println("А я уже начал бояться");
        }  else {
            System.out.println("Не повезло");
        }
        System.out.println(answer);
    }
}