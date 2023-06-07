import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    //  Bounds - ограничения
    // лист стрингов
    List<String> strings = new ArrayList<>();
    // ? - wildcard
    // лист чего угодно
    List<?> objects = new ArrayList<>();
    // лист чисел
    // ограничение такого рода называется upper bounden wildcard
    List<? extends Number> numbers = new ArrayList<>();

    // Lower bounded wildcard
    // есть еще нижняя граница - то есть, вместо нее можно подставить любого родителя.
    // Нижняя граница - от ребенка
    // Можем использовать Child Parent или Object
    // все те, кто является предкоком к Child или сам Child
    List<? super Child> childrens = new ArrayList<>();

    // Parent или любой наследник - пример верхней границы
    // все те, кто является наследником Parent или сам Parent
    List<? extends Parent> parents = new ArrayList<>();

    // Пример метода
    List<Parent> arr1 = List.of(new Parent(), new Parent());
    List<Child> arr2 = List.of(new Child(), new Child());

    // Метод работает с любыми листами, подходящими под описание
    System.out.println(getFirst(arr1));
    System.out.println(getFirst(arr2));

    // List<Parent> не является родителем List<Child>
  }
  public static Parent getFirst(List<? extends Parent> list){
    return list.get(0);
  }
  // совсем сложный пример и дженерик и wildcard
  public static <T> T getFirstVer2(List<? extends T> list){
    return list.get(0);
  }
}