public class Main {
    public static void main(String[] args) {
        // +  может быть либо сложением, либо может объединять строки
        int x = 9;
        int y = 7;
        String n = "9";
        String z = "7";
        // вот это понятно:
        System.out.println(x + y); // 16 - целое число
        System.out.println(n + z); // "97" - строка
        // а вот это?
        System.out.println(x + n); // "99" - строка
        // если в слева или справа от оператора стоит String
        // то будет операция объединения строк (конкатенация), а не сложение
        System.out.println(9 + 18 + "9"); // "279" - String
        // 9 + 18   - первая операция - 27
        // 27 + "9" - вторая операция "279"
        System.out.println("9"+ 9 + 18);  // "9918"
        // "9" + 9  - первая операция
        // "99"+ 18 - вторая операция
        System.out.println("9"+ (9 + 18)); // "927"
        // 9 + 18   - первая операция - 27
        // "9" + 27 - вторая операция

        // Численные типы, целые
        //  byte
        byte b = 12;  // пример
        // можем посмотреть минимальное и максимальное значение диапазона
        System.out.println("*****byte*****");
        System.out.println(Byte.MIN_VALUE); // -128
        System.out.println(Byte.MAX_VALUE); //  127
        // сколько занимает памяти
        System.out.println(Byte.SIZE);      // 8 - количество бит
        System.out.println(Byte.BYTES);     // 1 - количество байт
        // у нас есть восемь бит(1 либо 0) для хранения
        // как возводить в степень
        // первое число возводим в степень второго числа
        System.out.println(Math.pow(2, 7));
        // 7 бит уходит на числа - до 128 = 2 в степени 7
        // 1 бит уходит на знак + или -
        // byte m = 200; // эта строчка выдаст ошибку
        System.out.println("***** short *****");
        System.out.println(Math.pow(2, 15)); // 2 в степени 15
        System.out.println(Short.MIN_VALUE); // - 32768
        System.out.println(Short.MAX_VALUE); //   32767
        System.out.println(Short.SIZE);      // 16 bit
        System.out.println(Short.BYTES);     // 2  byte
        short s = 123;
        //
        System.out.println("**** int ****");
        int i = 12312312;
        System.out.println(Integer.MIN_VALUE); // -2 147 483 648
        System.out.println(Integer.MAX_VALUE); //  2147483647
        // переполнение
        System.out.println(Integer.MAX_VALUE + 5);
        // мы попали в минимальное значения
        //
        System.out.println("**** long ****");
        System.out.println(Math.pow(2, 63)); // 2 в степени 63
        long l = 52L; // когда создаем long - указываем букву l на конце - постфикс

        // Числа с плавающей точкой
        // float
        float f = 123.2f; // c постфиксом f, без него ошибка
        float f1 = 123f;
        System.out.println(f);
        // double
        double d = 123.5; // и без постфикса работает
        double d2 = 123.5d; // но можем и указать постфикс d
        System.out.println(d); // дабл более точный, больше диапазон
        System.out.println(d2);

        // Позанимаемся математикой
        // Математические операторы:
        // +, -, *, /, % -целочисленное деление
        // Оператор присваивания: =
        int firstNumber = 10;
        int secondNumber = 25;
        int sum = firstNumber + secondNumber;
        System.out.println(sum);  // 35 - int
        int mult = firstNumber * secondNumber;
        System.out.println(mult); // 250 - int
        int div = firstNumber / secondNumber;
        System.out.println(div);  // 0 - потому что округлил до int
        double div2 = (double) firstNumber/secondNumber;
        // только теперь получилось
        System.out.println(div2); //
        double tryMe = 4.5678;
        int reborn = (int) tryMe;
        System.out.println(reborn); // показал только целую часть
    }
}