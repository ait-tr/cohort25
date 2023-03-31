public class Main {
    public static void main(String[] args) {
        //   while_intro
        System.out.println("Почисти картошину");
        System.out.println("Почисти картошину");
        int i = 8;
        while (i < 10) {
            System.out.println(i);
            i++; // i = i + 1;
        }
        int j = 0;
        while (j > -25) {
            System.out.println(j);
            j--; // j = j - 1;
        }
        //1. вывести в консоль числа от 75 включительно до 136 включительно
        //2. вывести в консоль числа от -75 до -98 включительно
        // -75
        // -76
        // и так далее
        System.out.println("****** 1  ******");
        int n = 75;
        while (n <= 136) {
            System.out.println(n);
            n++;
        }
        System.out.println("****** 2 ******");
        int z = -75;
        while (z >= -98) {
            System.out.println(z);
            z--;
        }

        System.out.println("****** Пример ******");
        // "Moo" x 30 раз
        int m = 0;
        while (m < 30) {
            System.out.println("Moo");
            m++;
        }
        //
        System.out.println("****** 3 ******");
        // Выводить в консоль цифры от одного до ста
        // если число кратно 3-м (делится на три без остатка)
        // то мы выводим еще слово "бинго"
        // Пример
        // 1       *
        // 2
        // 3 бинго
        // 4       *
        // 5
        // 6 бинго
        // 7       *
        // 8
        // ...
        // 99 бинго
        // 100
        int b = 1;
        while (b <= 100) {
            if (b % 3 == 0) {
                System.out.println(b + " bingo");
            } else {
                System.out.println(b);
            }
            b++;
        }
        // от Константина:
        int k = 1;
        while (k <= 100) {
            System.out.println(
                    (k % 3 == 0) ? k + " bingo" : k
            );
            k++;
        }
        // от Майи
        int l = 1;
        while (l <= 100) {
            System.out.println(getMessageByNumber(l));
            l++;
        }
        System.out.println("***** пример другого шага *****");
        int f = 1;
        while (f < 20) {
            System.out.println(f);
//            f++; // f = f + 1
            f = f + 2;
        }
        // Синтаксический сахар - более лаконичный синтаксис
        // a = a + 1;   ---> a +=1;  либо a++;
        // a = a - 1;   ---> a -=1;  либо a--;
        // a = a + 2;   ---> a +=2;
        // a = a * 9;   ---> a *=9;
        // a = a / 4;   ---> a /=4;
        // тоже самое работает и со String
        // a = a + "yes"; ---> a +="yes";
        int s = 10;
        s *= 9;
        System.out.println(s);
        // пример для String
        String str1 = "Oh";
        str1 += " Yehe";
        System.out.println(str1);



    }

    // метод от Майи
    public static String getMessageByNumber(int number) {
        return number % 3 == 0 ? number + "bingo" : "" + number;
    }

}