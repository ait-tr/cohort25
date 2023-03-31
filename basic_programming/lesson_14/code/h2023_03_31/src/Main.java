public class Main {
    public static void main(String[] args) {
        /*
        ### Задача 1
        Напишите метод, который получает три целых числа и возвращает true,
        первое и второе число в сумме дают третье числу, иначе false.
        ### Задача 2
        Напишите метод, который получает три целых числа и возвращает true,
        если среди этих чисел есть такое, которое равно сумме двух оставшихся чисел.
        Например:
        (12,15,7) -> false;
        (8,15,7) -> true;
        Подсказка: используйте метод, написанный в задаче 1.
         */
        System.out.println(firstTwoAreEqualToThird(5, 6, 10));
        System.out.println(anyTwoAreEqualToThird(8, 15, 7));
    }

    public static boolean anyTwoAreEqualToThird(int a, int b, int c) {
        // a + b == c || b + c == a || c + a == b
        return firstTwoAreEqualToThird(a, b, c)
                || firstTwoAreEqualToThird(b, c, a)
                || firstTwoAreEqualToThird(c, a, b);
    }

    public static boolean firstTwoAreEqualToThird(int a, int b, int c) {
        return (a + b) == c;
    }
}