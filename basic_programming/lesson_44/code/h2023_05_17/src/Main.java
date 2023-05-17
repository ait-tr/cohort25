import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {
//    ## 1
//    Создайте класс Student со следующими полями: String fName, String lName, int doneHomeWork, int missingLesson}.
//  Реализуйте в нем интерфейс Comparable<Student>.
//  Студенты должны быть сравниваемы по количеству пропущенных уроков.
//  Создайте список студентов, отсортируйте этот список в порядке по возрастанию пропущенных студентом уроков.
//
//      ## 2 (дополнительно)
//  Реализуйте программу, которая выводит на экран список студентов. Спрашивает у пользователя в каком порядке нужно отсортировать список. Выводит на экран список студентов в нужном порядке.
//
//      *Подсказка 1*. Запрос «в каком порядке сортировать» можно организовать, например, следующим образом:
//      “1 -по имени и фамилии, 2 - по количеству пропусков, 3 – по количеству выполненных работ. Выберите номер сортировки:
//
//      *Подсказка 2*. Для каждого варианта необходимо создать свой компоратор.
    Student bob = new Student("Bob", "Marley", 0, 44);
    Student john = new Student("John", "Lehnon", 30, 5);
    bob.compareTo(john);
    List<Student> students = new ArrayList<>();
    students.add(bob);
    students.add(john);
    students.add(new Student("Irina", "Johns", 23, 4));
    students.add(new Student("Boris", "Johns", 66, 2));

    System.out.println("До сортировки:");
    System.out.println(students);

    System.out.println("После сортировки:");
    Collections.sort(students);
    System.out.println(students);
    // отсортируем по компаратору
    students.sort( new StudentsByHomeworkComparator());
    System.out.println("После второй сортировки");
    System.out.println(students);
    // отсортируем по компаратору в обратном порядке
    students.sort( new StudentsByHomeworkComparator().reversed());
    System.out.println("После сортировки в обратном порядке");
    System.out.println(students);

    // Johns Anna
    // Johns Bob
    // “ 1-по имени и фамилии, 2- по количеству пропусков, 3 – по количеству выполненных работ.
    System.out.println("Выберите способ сортировки");
    System.out.println("1 - по имени и фамилии, 2 - по количеству пропусков, 3 – по количеству выполненных работ.");
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String answer = reader.readLine();
    switch (answer) {
      case "1" -> students.sort(new StudentsByNamesComparator());
      case "2" -> Collections.sort(students);
      case "3" -> students.sort(new StudentsByHomeworkComparator());
      default -> System.out.println("Нет такого варианта сортировки");
    }
    System.out.println(students);
        String a = "Ivan 7";
        String b = "Ivandasd";


  }
}