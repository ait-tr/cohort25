public class Accum {
    public static void main(String[] args) {
        /*
         Напишите метод который ничего не принимает в качестве параметров
         возвращает int сумму чисел от 1 до 120.
         (1 + 2 + 3 + .... + 120)
         Вам понадобится отдельная переменная для суммы,
         значение в которой вы будете обновлять.
         Подсказка, подумайте, где ее объявить.
         */
        System.out.println(getSumOfNumber());

        int result = getSumOfNumber();
        System.out.println(result);
    }

    public static int getSumOfNumber() {
        int sum = 0;    // такого рода переменные называются аккумуляторами
        // и аккумулятор стоить объявить до цикла
        for (int i = 1; i <= 120; i++) {
            sum += i; // sum = sum + i;
        }
        return sum;
    }

    /*
    Создайте метод multiplyString, который принимает:
        String word - слово
        int n - количество повторений
    Метод возвращает тип String, слово повторенное n раз.
    Пример вызова метода:
        multiplyString("apple", 3); --> "appleappleapple"
        multiplyString("cat_", 7); --> "cat_cat_cat_cat_cat_cat_cat_"
    P.S. Используйте цикл, а не метод repeat
     */
    public static String multiplyString(String word, int n) {
        String accumulator = "";
        // к ней будете присоединять строки
        // здесь ваш цикл // обновляете в нем значение переменной accumulator
        // здесь ваш код

        return accumulator; // вернули, все что приплюсовали
    }
}
