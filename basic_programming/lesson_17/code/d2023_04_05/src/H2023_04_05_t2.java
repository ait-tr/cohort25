public class H2023_04_05_t2 {
    public static void main(String[] args) {
/*
Напишите метод indexOf, который возвращает индекс заданного символа в заданной строке.
Т.е. метод принимает строку и char и возвращает позицию, где этот символ первый раз встречается в строке.
Если в заданной строке нет заданного символа, то метод должен вернуть -1.
Примеры:
   indexOf("Java is the best", 'i') -> 5
   indexOf("Java is the best", 'q') -> -1
   indexOf("Java is the best", 'a') -> 1
Естественно, в рамках этой задачи нельзя использовать стандартный indexOf класса String
 */
        // "cat", 'c' --> 0
        System.out.println(indexOf("cactus", 'x'));
    }

    public static int indexOf(String str, char symbol) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == symbol) {
                return i;
            }
        }
        return -1;
    }
}
