import java.util.Map;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) {
    TreeMap<Integer, String> months = new TreeMap<>();
    months.put(1, "January");
    months.put(6, "June");
    months.put(12, "December");
    months.put(2, "February");
    months.put(3, "March");
    System.out.println(months);
    // {1=January, 2=February, 3=March, 6=June, 12=December}
    // Расположились по порядку возрастания ключей


    // I. Методы который достались от SortedMap

    // firstKey - возвращает наименьший ключ - он же первый
    System.out.println(months.firstKey()); // 1
    // lastKey - возвращает наибольший ключ - он же последний
    System.out.println(months.lastKey());  // 12
    // {1=January, 2=February}  - возвращает "подмап"
    // headMap - все пары до указанного ключа - не включительно
    System.out.println(months.headMap(3));
    // обратите внимание в скобочках находится не индекс
    // а ключ - то есть бы ключи были объектами какого-то класса
    // пришлось бы указать объект
    // tailMap - все пары от указанного ключа - включительно
    // {3=March, 6=June, 12=December}
    System.out.println(months.tailMap(3));

    // subMap - все пары от указанного ключа до второго указанного ключа
    // второй не включительно
    System.out.println(months.subMap(2, 6)); // {2=February, 3=March}

    // II.
    // entry - пара
    System.out.println(months.firstEntry()); // получаем первую пару
    // lastEntry - возвращает последнюю пару
    Map.Entry<Integer, String> entry2 = months.lastEntry();

    //  получаем первую пару - она удаляется из словаря/map
    System.out.println(months.pollFirstEntry());
    // январь пропал
    System.out.println(months); // {2=February, 3=March, 6=June, 12=December}
    // ближайший ключ, который больше или равен указанному
    System.out.println(months.ceilingKey(4));
    // ближайший ключ, который меньше или равен указанному
    // если такого нет - то null
    System.out.println(months.floorKey(1)); // null
    System.out.println(months.floorKey(2)); // 2
    // ближайший - который строго меньше указанного
    System.out.println(months.lowerKey(2)); // null

    // создадим телефонную книгу
    // TreeMap<Contact, String> telephoneBook
    // класс Contact содержит поля:
    //  - firstName;
    //  - secondName;
    // {"Abramov Alex"="+498212323123", "Borisov Gleb"="+498212323123"}

    TreeMap<Contact, String> telephoneBook = new TreeMap<>();
    telephoneBook.put(
        new Contact("Anna", "Belyayeva"), "+498212323123");
    // мы обновили значение по ключу
    telephoneBook.put(
        new Contact("Anna", "Belyayeva"), "+498212323143");
    telephoneBook.put(
        new Contact("Tamara", "Urizkay"), "+498212323125");
    System.out.println(telephoneBook);

  }
}