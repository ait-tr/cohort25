# Static
Ссылка на презентацию: [ссылка](https://github.com/ait-tr/cohort25/blob/main/basic_programming/lesson_37/static.pdf)

Кроме обычных методов и полей класс может иметь статические поля, методы, константы и инициализаторы. 
Например, главный класс программы имеет метод main, который является статическим:

```java
public static void main(String[] args) {

}
```
Для объявления статических переменных, констант, методов и инициализаторов перед их объявлением указывается ключевое слово static.

### Статические поля
При создании объектов класса для каждого объекта создается своя копия нестатических обычных полей. А статические поля являются общими для всего класса. Поэтому они могут использоваться без создания объектов класса.

Например, создадим статическую переменную:

````java
public class Program{
      
    public static void main(String[] args) {
         
        Person tom = new Person();
        Person bob = new Person();
         
        tom.displayId();    // Id = 1
        bob.displayId();    // Id = 2
        System.out.println(Person.counter); // 3
         
        // изменяем Person.counter
        Person.counter = 8;
         
        Person sam = new Person();
        sam.displayId();    // Id = 8
    }
}
class Person{
     
    private int id;
    static int counter=1;
     
    Person(){
        id = counter++;
    }
    public void displayId(){
     
        System.out.printf("Id: %d \n", id);
    }
}
````

Класс Person содержит статическую переменную counter, которая увеличивается в конструкторе и ее значение присваивается переменной id. То есть при создании каждого нового объекта Person эта переменная будет увеличиваться, поэтому у каждого нового объекта Person значение поля id будет на 1 больше чем у предыдущего.

Так как переменная counter статическая, то мы можем обратиться к ней в программе по имени класса:

```java
System.out.println(Person.counter); // получаем значение
Person.counter = 8;                 // изменяем значение
```
Консоль:
```console
Id = 1
Id = 2
3
Id = 8
```

### Статические методы
Статические методы также относятся ко всему классу в целом. Например, в примере выше статическая переменная counter была доступна извне, и мы могли изменить ее значение вне класса Person. Сделаем ее недоступной для изменения извне, но доступной для чтения. Для этого используем статический метод:

```java
public class Program{
      
    public static void main(String[] args) {
         
        Person.displayCounter();    // Counter: 1
         
        Person tom = new Person();
        Person bob = new Person();
         
        Person.displayCounter();    // Counter: 3
    }
}
class Person{
     
    private int id;
    private static int counter = 1;
     
    Person(){
        id = counter++;
    }
    // статический метод
    public static void displayCounter(){
         
        System.out.printf("Counter: %d \n", counter);
    }
    public void displayId(){
     
        System.out.printf("Id: %d \n", id);
    }
}
```

Теперь статическая переменная недоступна извне, она приватная. А ее значение выводится с помощью статического метода displayCounter. Для обращения к статическому методу используется имя класса: Person.displayCounter().

При использовании статических методов надо учитывать ограничения: в статических методах мы можем вызывать только другие статические методы и использовать только статические переменные.

Вообще методы определяются как статические, когда методы не затрагиют состояние объекта, то есть его нестатические поля и константы, и для вызова метода нет смысла создавать экземпляр класса. 