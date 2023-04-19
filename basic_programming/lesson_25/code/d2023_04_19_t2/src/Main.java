import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Структуры данных: ArrayList
        ArrayList<String> names = new ArrayList<>();
        // метод add для добавления элементов в Array
        names.add("Sam Morgunov");
        names.add("Bob Margolin");
        names.add("Will Smith");
        System.out.println(names);
        // метод get для получения элемента по индексу
        System.out.println(names.get(0)); // "Sam Morgunov"
        System.out.println(names.get(2)); // "Will Smith"
        // метод для того чтобы заменить значение в ячейке
        // например заменим элемент под индексом 2 на новое значение
        names.set(2, "Bread Pit");
        System.out.println(names);
        // метод, чтобы убрать элемент из ArrayList по индексу
        // до [Sam Morgunov, Bob Margolin, Bread Pit]
        names.remove(1);
        // после [Sam Morgunov, Bread Pit]

        // Создайте ArrayList стрингов
        // Положите в него следующие значения:
        // "apple", "orange", "lime", "mango"
        // Выведите лист в консоль.
        // Замените "lime" на "lemon"
        // Распечатайте ArrayList
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("orange");
        fruits.add("lime");
        fruits.add("mango");
        System.out.println(fruits);
        fruits.set(2, "lemon");
        System.out.println(fruits);
        System.out.println(fruits.get(1));

        // если нужно очистить ArrayList
        // используйте метод clear - он удаляет все элементы
        names.clear();
        System.out.println(names); // []

        // метод size()
        System.out.println(names.size()); // 0
        System.out.println(fruits.size()); // 4
        // с помощью цикла for вывести все элементы fruits
        for (int i = 0; i < fruits.size(); i++){
            System.out.println(fruits.get(i));
        }
        // Некоторые нюансы с примитивными типами
        // В ArrayList  нельзя хранить примитивные типы
        // Вместо примитивных типов пишем Классы "обертки"
        // int --> Integer
        // double --> Double
        // boolean --> Boolean
        // ...
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(9);
        numbers.add(29);
        numbers.add(30);
        System.out.println(numbers);

        // Создайте arrayList чисел, назовите его numbers2
        // Добавьте произвольное число чисел
        // С помощью цикла просуммируйте все значения в ArrayList
        // Выведите эту сумму в консоль
        ArrayList<Integer> numbers2 = new ArrayList<>();
        numbers2.add(28);
        numbers2.add(24);
        numbers2.add(100);
        int sum = 0;
        for(int i = 0; i < numbers2.size(); i++){
            sum += numbers2.get(i); //в массиве было бы: numbers2[i]
        }
        System.out.println(sum);
    }
}