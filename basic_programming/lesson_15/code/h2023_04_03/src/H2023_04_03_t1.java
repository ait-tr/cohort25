public class H2023_04_03_t1 {
    public static void main(String[] args) {
        // Напишите метод. Каждый раз когда мы его вызываем - он печатает числа 7 14 21 28 35 ... 98.
        // Метод ничего не принимает.
        printFromSeven();    // первая версия
        printFromSevenV2();  // вторая версия

    }
    public static void printFromSeven() {
        int i = 7;
        while (i <= 98) {
            System.out.println(i);
            i += 7;  //
        }
    }

    public static void printFromSevenV2() {
        int i = 7;
        while (i <= 100) {
            if (i % 7 == 0) {
                System.out.println(i);
            }
            i++;
        }
    }
}
