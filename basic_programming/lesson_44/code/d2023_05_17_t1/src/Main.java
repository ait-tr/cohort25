import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // класс LocalDate
    LocalDate today = LocalDate.of(2023, 5, 17);
    System.out.println(today);
    // методы
    System.out.println(today.getDayOfWeek()); // день недели в эту дату
    LocalDate newYear = LocalDate.of(2022, 12, 31);
    System.out.println(today.compareTo(newYear));

    // создадим заготовку для магазина
    // Создать абстрактный класс Item с полями
    //   - double цена
    //   - double рейтинг
    //   - int скидка - процент скидки
    //   - LocalDate date - дата выпуска
    //  и методом:
    //   - рассчитать цену с учетом скидки double getDiscountedPrice()

    // Создать два произоводных класса Suitcase и Bicycle
    // можете сделать в них поля на ваш выбор

    // Нужно создать ArrayList товаров Item
    // нужно спросить у пользователя варианты, как он хочет отсортировать
    // 1 - новинки - от самых поздних товаров
    // 2 - по рейтингу - от самых популярных к менее популярным
    // 3 - по цене со скидкой - от дорогих к дешевым
    // 4 - по цене со скидкой - от дешевых к дорогим

    // и распечатать отсортированный ArrayList
    ArrayList<Item> items = new ArrayList<>();
    items.add(new Bicycle(400, 4.5, 15,
        LocalDate.of(2023, 5, 1),
        "Stells", 2));
    items.add(new Bicycle(900, 4.8, 5,
        LocalDate.of(2022, 5, 1),
        "Linux", 2));
    items.add(new Suitcase(350, 5, 0,
        LocalDate.of(2023, 3, 1),
        "Samsonite", "L"));
    items.add(new Suitcase(150, 5, 0,
        LocalDate.of(2023, 3, 1),
        "Dalsy", "XS"));
    // вызов метода - он отсортирует и распечатает
    chooseAndSort(items);


  }
  public static void chooseAndSort(ArrayList<Item> list){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Как отсортировать?");
    System.out.println("\n 1 - новинки - от самых поздних товаров " +
        "\n 2 - по рейтингу - от самых популярных к менее популярным " +
        "\n 3 - по цене со скидкой - от дорогих к дешевым " +
        "\n 4 - по цене со скидкой - от дешевых к дорогим");
    int answer = scanner.nextInt();
    switch (answer) {
      case 1 -> list.sort(new ItemByDateComparator().reversed());
      case 2 -> list.sort(new ItemByRatingComparator().reversed());
      case 3 -> list.sort(new ItemByDiscountPriceComparator().reversed());
      case 4 -> list.sort(new ItemByDiscountPriceComparator());
      default -> System.out.println("Нет такого варианта сортировки");
    }
    System.out.println(list);
  }
}