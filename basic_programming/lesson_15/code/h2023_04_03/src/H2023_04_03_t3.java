public class H2023_04_03_t3 {
    public static void main(String[] args) {
        /*
        Имануил Кант любит считать свои шаги во время прогулки.
        Прогулка его составляет 300 шагов.
        Каждый шаг он считает в слух.
        Но вместо чисел кратных 6 (это числа, которые делятся на 6 без остатка) он говорит - "Himmel und Erde".
        Вместо ста он заявляет "Sagen Sie mir, kann man in Ihrem Land durch Null teilen?"
        Выведите этот разговор Канта с самим собой в консоль.
         */
        int i = 1;
        while (i <= 300) {
            if (i % 6 == 0) {
                System.out.println("Himmel und Erde");
            } else if (i == 100) {
                System.out.println("Sagen Sie mir, kann man in Ihrem Land durch Null teilen?");
            } else {
                System.out.println(i);
            }
            i++;
        }


    }
}
