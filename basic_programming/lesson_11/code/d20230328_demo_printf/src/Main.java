public class Main {
    public static void main(String[] args) {
        double perimeter= 125.66370614359172;
        double area= 1256.6370614359173;


        //форматированный вывод
        // %f - вывод дробного значения
        // %n - перенос строки
        // %d - вывод целого число
        // %s - вывод строк
        // %c - char

        System.out.println("Форматированный вывод");
        System.out.printf("Perimeter: %f%n", perimeter);  // форматированный вывод не переходит на другую строку
        System.out.printf("Perimeter: %f area: %f %n", perimeter, area);
        System.out.printf("Perimeter: %.2f area: %.3f %n", perimeter, area);
        int a=100;
        int b=120;
        int c=150;
        String str="qwertyuiop[";
        System.out.printf("a:%d b:%d  c:%d %s %n %s %n", a, b,c, "вот комментарий-строка",str);
        int intValue=69;
        System.out.printf("переменная как char: %c  переменная как целое значение: %d%n", intValue,intValue);
        char charValue='q';
        System.out.printf("переменная как char: %c%n", charValue);
    }
}