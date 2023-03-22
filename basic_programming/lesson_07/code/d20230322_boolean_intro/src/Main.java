import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Мы уже изучили математические операторы: +, -, /, *, %
        // Операторы сравнения: >, <, >=, <=
        // их результат true, false
        int x = 10;
        int y = 12;
        int z = 10;
        System.out.println(x < y);  // true
        System.out.println(x > y);  // false
        System.out.println(x <= y); // true
        System.out.println(x >= z); // true
        //
        System.out.println(x == z); // true  // равенство
        System.out.println(x != z); // false // неравенство

        // if - else
        int height = 100; // высота ребенка
        if (height == 60) {
            System.out.println("Проходи на колесо обозрения");
            System.out.println("Не забудь пристегнуться");
        }
//        if(условие){
//            // код который хотим выполнить
//        }
        // Задание
        // Запросите у пользователя его возраст
        // Если возраст больше 26 лет
        // то выведите в консоль фразу
        // "Я не могу продать вам студенческий проездной"
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите возраст");
        int age = scanner.nextInt();
        if (age > 26) {
            System.out.println(
                    "Я не могу продать вам студенческий проездной");
        }
        if (age <= 26) {
            System.out.println("Вот ваш проездной");
        }


        // Есть еще одна условная конструкция if else
        int numberOfHands = 2;
        if (numberOfHands == 2) {
            System.out.println("Все ок!");
        } else {
            System.out.println("Бегите скорее в госпиталь");
        }
        // Спросите у пользователя, сколько у него детей
        // если меньше или равно двум - выведите в консоль "Счастливчик"
        // если больше двух - выведите в консоль "Ну ты держись"
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Сколько у вас детей?");
        int numberOfKids = scanner2.nextInt();
        if (numberOfKids <= 2) {
            System.out.println("Счастливчик");
        } else {
            System.out.println("Ну ты держись");
        }
        // == != мы можем использовать только с примитивными типами
        //
        // Пользователь вводит слово.
        // Если начинается на char A - то выводим - "Горячо"
        // Если в нем 8 символов - то выводим "Нужная длина"
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Угадайте слово");
        String answer = scanner3.nextLine();
        char first = answer.charAt(0);
        if (first == 'А') {  // русская А
            System.out.println("Горячо");
        }
        if (answer.length() == 8) {
            System.out.println("Нужная длина");
        }
        // тип boolean имеет только два возможных значения
        // true, false - без кавычек
        // в переменную boolean мы можем сохранить результат проверки
        // какого-либо условия
        boolean b1 = 5 > 10;
        System.out.println(b1); // false
        if (b1) {   // в круглых скобках true или false - то есть boolean
            System.out.println("Boom");
        }
    }
}