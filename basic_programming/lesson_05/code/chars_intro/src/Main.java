
public class Main {
    public static void main(String[] args) {
        char a1 = 'a';  // char с одинарными кавычками
        System.out.println(a1);

        char a2 = 65;   // ввели целый номер // десятичный
        // без кавычек
        System.out.println(a2);

        char a3 = 65 + 32;
        System.out.println(a3);

        char a4 = 147;
        System.out.println(a4);

        char copySign = 184;

        // Таблица:
        //   ASCII - 256 - маленькая таблица - символы пронумерованы
        //   Unicode    - необъятная таблица - Unicode
        // Кодировка: UTF-8
        //   как эти знаки будут преобразовываться
        //   для храниться в компьютере в битах

        System.out.println("" + a1 + a2);



    }
}