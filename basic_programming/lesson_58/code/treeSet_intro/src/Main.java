import java.util.*;

//  tree_data_structures
  //  TreeSet
public class Main {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("John");
    list.add("Bob");
    list.add("Anna");
    list.add("Anna");
    System.out.println(list);
    // Хеш структуры данных работали на основе хэш таблиц
    Set<String> namesSet = new HashSet<>();
    namesSet.add("John"); // порядок добавления не сохранился
    namesSet.add("Bob");
    namesSet.add("Anna");
    namesSet.add("Anna"); // не добавился дубликат
    // если работаем с другим классами, то
    // не забываем переопределить equals и hashCode
    System.out.println(namesSet);
    // Древовидные структуры
    Set<Integer> numbers = new TreeSet<>();
    numbers.add(5);
    numbers.add(4);
    numbers.add(7);
    numbers.add(10);
    numbers.add(10);
    System.out.println(numbers);
    // данные отсортированы в порядке естественного следования
    // от меньшего к большему
    // Но для других классов, если хотим работать с древовидными
    // структурами мы должны либо реализовать Comparable,
    // либо передавать в конструктор Comparator
    // Иными словами у нас должна быть прописана логика того,
    // что считать большим, а что меньшим.
    // Посмотрели бинарные деревья
    // Глубина дерева, корень, лист
    // Сбалансированное - не сблансированное
    // Создайте TreeSet<Person>
    // у Person должен быть возраст и имя
    // Подобавляйте персон, как закономерность?
    // Что странно?
    // Со звездочкой: используйте компаратор.
//    new TreeSet<>(new Comparator<Object>() {
//    })
    Set<Person> people = new TreeSet<>();
    people.add(new Person("John", 18));
    people.add(new Person("Bob", 18));
    people.add(new Person("Ann", 27));
    System.out.println(people);

    // теперь с компаратором
    Set<Person> peopleReversed = new TreeSet<>(
        new Comparator<Person>() {
          @Override
          public int compare(Person o1, Person o2) {
            if(o1.getAge() == o2.getAge()){
              return o1.getName().compareTo(o2.getName());
            }
            return Integer.compare(o1.getAge(), o2.getAge());
          }
        }.reversed()
    );
    peopleReversed.add(new Person("John", 18));
    peopleReversed.add(new Person("Bob", 18));
    peopleReversed.add(new Person("Ann", 27));
    System.out.println(peopleReversed);
    // Для работы с Tree нам обязательно нужен либо Comparable
    // либо Comparator
  }
}