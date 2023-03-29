public class Main {
    public static void main(String[] args) {
        // вызов метода
//        System.out.println("Начало кода");
//        hello();
//        System.out.println("Место со *");
//        hello();
//        //
        robbery();
        // за что мы любим методы больше всего?
        // значение --> [BLACK BOX] --> новое значение
        System.out.println(addFive(100));
        System.out.println(multiplyByEight(10));
        // по-другому
        int result2 = multiplyByEight(12);
        System.out.println(result2);
        System.out.println(sum(33, 12));
        // создайте и возовите метод деление
        // - он принимает в качестве параметров два double
        // - возвращаемое значение double
        System.out.println(divide(100, 20));
        System.out.println(cut("hospital"));
    }
    // cut
    // метод принимает String
    // метод возвращает новый String
    // он оставляет только первые 4 буквы от слова и добавляет многоточие "..."
    // "Аквариум" --> [метод] --> "Аква..."
    public static String cut(String word){
        return word.substring(0, 4) + "...";
    }
    public static int sum(int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }
    public static double divide(double firstNumber, double secondNumber){
        return firstNumber / secondNumber;
    }

    public static int addFive(int number){
        return number + 5;
    }
    // объявите метод с именем multiplyByEight,
    // метод возвращает тип int
    // метод принимает тип int
    // метод должен умножать значение на 8
    // вызовите метод в main два раза с разными аргументами
    public static int multiplyByEight(int number){
        return number * 8;
    }
    // объявление метода
    // public static // тип возвращаемого значения // имя
    // void - пустота
    public static void hello(){
        System.out.println("Добрый день!");
        System.out.println("Как ваши дела?");
    }
    // Объявите метод с названием robbery -
    // пусть метод вывод в консоль фразу:
    // Это ограбление, поэтому все деньги и золото бросайте
    // в этот мешок.
    // Если будете делать как сказано, никто не пострадает.
    // Вызовите этот метод два раза
    public static void robbery(){
        hello();
        System.out.println(
                "Это ограбление, поэтому все деньги и золото бросайте в этот мешок."
        );
        System.out.println("Если будете делать как сказано, никто не пострадает.");
    }
}