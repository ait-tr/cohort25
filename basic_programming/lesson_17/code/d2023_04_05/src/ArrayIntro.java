public class ArrayIntro {
    public static void main(String[] args) {
        int age = 19;
        age = 28;
        // обычная - одна ячейка памяти,
        // в нее помещается только одно значение
        //
        int[] numbers = {5, 7, 9, 28};
        String[] names = {"Ivan", "Sveta", "Galya"};
        System.out.println(names[2]); // "Galya"
        names[2] = "Semeon";
        System.out.println(names[2]); // "Semeon"
        // Записали новое значение в ячейку под индексом 2
        System.out.println("******");
        // Создайте массив фруктов
        // с элементами: "Orange", "Apple", "Banana", "Grapefruit"
        // замените "Banana" на "Mango"
        // и распечатайте по очереди все элементы массива
        String[] fruits = {"Orange", "Apple", "Banana", "Grapefruit"};
        fruits[2] = "Mango";
        System.out.println(fruits[0]);
        System.out.println(fruits[1]);
        System.out.println(fruits[2]);
        System.out.println(fruits[3]);
        for (int i = 0; i < fruits.length; i++) {
            System.out.println(i);
            System.out.println(fruits[i]);
        }
        // Создайте массив char со значениями:
        // 'f', 'g', 'h', 'j', 'k'
        // *** поменяйте значения в нулевой
        // и последней ячейках местами ***

        // И после этого распечатайте элементы массива
        // при помощи цикла for
        char[] letters = {'f', 'g', 'h', 'j', 'k'};
        // скопировали значение из 0 ячейки на хранение, чтобы не пропало
        char temp = letters[0];
        // заменили значение в нулевой ячейке на значение из последней ячейки
        letters[0] = letters[letters.length - 1];
        // заменили значение в последней ячейке
        // на значение из переменной для временного хранения temp
        letters[letters.length - 1] = temp;
        for (int i = 0; i < letters.length; i++) {
            System.out.println(letters[i]);
        }

        // Выделение памяти и объявление.
        // Объявление переменной для массива
        String[] breeds; // объявление = указание типа данных и имени переменной
        // Создание массива или выделение памяти
        //  Вариант 1 -со словом new и указанием значений
        //  создали массив длинной 2, с указанными значениями
        //  сохранили этот массив в созданную ранее переменную breeds
        breeds = new String[]{"booldog", "tax"};

        //  Вариант 2 - можно выделить память под определенное
        //  количество ячеек без того, чтобы задавать значение.
        //    Создали переменную
        String[] planets;
        //    Создали массив, который наполнены значениями по умолчанию.
        //    Длину указываем в квадратных скобках.
        planets = new String[7];
        System.out.println(planets[2]); // null
        // null - значение по умолчанию для String и других ссылочных типов
        int[] years = new int[5]; // массив типа int длинной в пять
        System.out.println(years[2]); // 0
        // для примитивных типов значение по умолчанию
        // целочисленные - это 0
        // для double - 0.0
        // для boolean - false
        planets[0] = "Mercury";
        planets[1] = "Venus";
        planets[2] = "Earth";
        // Вариант 3 - сразу задать значение
        String[] cars = {"BMW", "Volkswagen", "KIA"};
    }
}
