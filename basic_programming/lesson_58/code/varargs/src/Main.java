import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    // varargs
    welcome("Ivan");
    welcome("Ivan", "John");
    welcome("Ivan", "John", "Kate");
    //
    goodbye("Ivan");
    goodbye("Ivan", "Kate");
    socialPhrase("Thank you", "Konstantin", "Oksana");
    // cоздайте метод
    // createTasksList -
    // метод принимает произвольное количество задач task
    // "wash dishes"
    // "clean house"
    // createTasksList("wash dishes", "clean house") ->
    // возвращаемое значение List<String>
    List<String> tasks = List.of("do smth", "do smth else");
    // List.of - создает неизменяемый (unmutable) лист
    // в этот лист ничего нельзя добавить
    // tasks.add("third task"); // здесь ошибка
    List<String> tasks2 = new ArrayList<>();
    tasks2.add("buy food"); // а вот так не было ошибки
    List<String> result =
        createTasksList("do homework", "repeat generics");
    System.out.println(result);
    // Создайте метод, который принимает произвольное число автомобилей.
    // Возвращает самый дорогой автомобиль.
    // Соответственно, вам потребуется создать класс Car с полями:
    // - title
    // - price
    Car mercedes = new Car("Mercedes", 20000);
    Car largus = new Car("Largus", 13000);
    System.out.println(getTheMostExpensiveOf(mercedes, largus));

  }

  public static Car getTheMostExpensiveOf(Car... cars) {
    Car mostExpensive = cars[0];
    for (Car car : cars) {
      if (car.getPrice() > mostExpensive.getPrice()) {
        mostExpensive = car;
      }
    }
    return mostExpensive;

//    return Collections.max(List.of(cars));
// но нужно реализовать интерфейс Comparable
    // или использовать компаратор
  }


  public static List<String> createTasksList(String... tasks) {
    List<String> list = new ArrayList<>();
    for (String task : tasks) {
      list.add(task);
    }
    return list;
    //  return new ArrayList<>(Arrays.asList(tasks));
  }

  public static void socialPhrase(String typeOfPhrase, String... names) {
    System.out.print(typeOfPhrase + " ");
    for (String name : names) {
      System.out.print(name + " ");
    }
    System.out.print("\n");
  }

  public static void goodbye(String... names) {
    System.out.print("Goodbye, ");
    for (String name : names) {
      System.out.print(name + " ");
    }
    System.out.print("\n");
  }

  public static void welcome(String name) {
    System.out.println("Welcome, " + name);
  }

  public static void welcome(String name, String name2) {
    System.out.println("Welcome, " + name + " " + name2);
  }

  public static void welcome(String name, String name2, String name3) {
    System.out.println("Welcome, " + name + " " +
        name2 + " " + name3
    );
  }

}