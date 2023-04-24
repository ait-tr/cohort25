import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // hashset
        HashSet<String> namesSet = new HashSet<>();
        namesSet.add("Orhan");
        namesSet.add("Maiia");
        System.out.println(namesSet);
        // Вывод 1: порядок добавления элементов не сохраняется
        namesSet.add("Maiia");
        System.out.println(namesSet);
        // Вывод 2: в хэшсете каждый элемент уникальный
        // - то есть невозможно хранить дублирующиеся значения
        // Методы:
        namesSet.add("Natalia");       // add - добавляет
        namesSet.remove("Maiia");   // remove - удаляет указанный объект
        System.out.println(namesSet);
        // Вывод 3: нет индексов и не предугадать порядок, нет порядка следования
        namesSet.size();               // size - показывает количество элементов
        namesSet.contains("Igor");     // contains - возвращает boolean
        // если указанный объект есть - вернет true
        // если объекта нет - вернет false
        // Вывод 4: поиск того, есть ли элемент - занимает минимальное
        // количество времени

        /*
        Спрашиваем у пользователя сколько он хочет ввести имен.
        После этого получаем от него имена через сканер.
        После этого выведите на экран количество уникальных элементов.
        То есть ответ на вопрос, сколько из этих имен было уникальных?
        "Количество уникальный имен: <количество>"
        */
        System.out.println("Сколько будете вводить имен?");
        Scanner scanner = new Scanner(System.in);
        int numberOfWords = Integer.parseInt(scanner.nextLine());
//        "12" --> 12
        HashSet<String> uniqueNames = new HashSet<>();
        for (int i = 0; i < numberOfWords; i++) {
            System.out.println("Введите имя №" + (i + 1));
            uniqueNames.add(scanner.nextLine());
        }
        System.out.println("Количество уникальный имен: " + uniqueNames.size());
    }
}