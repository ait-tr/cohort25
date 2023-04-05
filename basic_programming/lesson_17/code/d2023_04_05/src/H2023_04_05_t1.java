public class H2023_04_05_t1 {
    public static void main(String[] args) {
/*
Реализовать свой метод substring(). Т.е в метод приходит строка и два целых числа index1 и index2.
Метод возвращает подстроку, начиная с символа в позиции index1 до символа в позиции index2.
Причем символ в позиции index1 включаем в результат а символ в позиции index2 не включаем.
Если даны "ошибочные параметры", например index2<=index1 или один из индексов не попадает в строку, метод должен возвращать пустую строку
Примеры:
   substring("Java is the best", 0, 4) -> "Java"
   substring("Java is the best", 1, 6) -> "ava i"
   substring("Java is the best", 1, 60) -> ""
   substring("Java is the best", 8, 8) -> ""
Естественно, в рамках этой задачи нельзя использовать стандартный substring класса String
 */
        // cat // t == 2  length == 3// "cat".charAt(3)

        System.out.println(substring("horse", 10, 20)); // ""
        System.out.println(substring("horse", 2, 5));   // "rs"
        System.out.println(substring("Java is the best", 0, 4));
        System.out.println(substring("Java is the best", 1, 6));
        System.out.println(substring("Java is the best", 1, 60));
        System.out.println(substring("Java is the best", 8, 8));
    }

    public static String substring(String str, int index1, int index2) {
        if (index2 <= index1 || index2 > str.length()) {
            return "";
        }
        if (index1 < 0 || index1 > str.length()-1){
            return "";
        }
        String acc = "";
        for (int i = index1; i < index2; i++){
            acc += str.charAt(i);
        }
        return acc;
    }
}
