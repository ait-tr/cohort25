# Классы

Вся программа состоит из классов (class), эти классы взаимодействуют друг с другом.

У каждого класса есть:
- методы, определяющие поведение объектов этого класса.
- атрибуты, определяющие свойства объектов класса.

Среди методов класса можно выделить некоторые "особенные" методы:
- конструктор (constructor) - метод, который вызывается при создане объекта класса
- toString - метод, который определяет правила преобразования обеъкта класса в строку
- методы доступа к полям класса (getters & setters)
 


## Конструкторы

Конструктор (constructor) - от слова "конструировать" - создавать. Этот метод вызывается при создание объекта класса. Всякий раз, когда создается объект, после слова new вызывается метод-конструктор класса. 
```java
Cat cat= new Cat("Tom");
```
Название конструктора всегда совпадает с названием класса. Возвращаемого типа у конструктора **нет**.
```java
public class Cat {

  private String name;

  public Cat(String name) {
    this.name = catName;
  }
}
```
Класс может иметь несколько конструкторов, отличающихся набором параметров. Каждый из конструкторов определяет свой способ создания объекта. Если в классе не определен ни один конструктор - java добавляеет конструктор без аргументов, создающий "пустой" объект.
```javа
  public Cat() { }
```

## Служебное слово this
Служебное слово `this` позволяет обратиться к конкретному (текущему, **этому**) экземпляру класса:
```java
public class Cat {
  private String name;
  public Cat(String name) {
    this.name = name; // если не написать this, то будет изменён аргумент метода, а не атрибут объекта
  }
}
```

# Методы

Методы - действия, связанные с этим классом.

Все действия программы, все команды языка Java пишутся только внутри одного из методов.

Метод `public static void main(String[] args)` позволяет запустить программу, начиная с этого файла. В таком случае программа становится экземпляром класса, соответствующего этому файлу, и именно из команд, перечисленных в методе `main`, состоит код программы.


# Методы доступа к полям сеттеры (Setters) и геттеры (Getters)
Обычно атрибуты напрямую (из других классов) менять нельзя, они должны быть недоступны.
Поэтому все атрибуты пишем так:
```java
private Тип имяАтрибута;
```
Что бы обеспечить доступ к полям, создаем специальные методы Сеттеры (Setters) и Геттеры (Getters)
 *get* - получить .
 *set* - задать (установить).

## Сеттеры (Setters)
Название традиционно выглядит как `public void setАтрибут(ТипАтрибута новоеЗначение)`.

Метод позволяет как задать атрибут, если он не был задан конструктором, так и изменить уже заданный.

```java
public class Cat {

  private String name;

  public setName(String catName) {
    name = catName;
  }
}
```

В сеттерах может быть дополнительная проверка:
```java
public class Person {

  private int age;

  public void setAge(int age) {
    if (age < 0) {
      System.out.println("Возраст не может быть отрицательным: " + age);
      return;
    }
    this.age = age;
  }
}
```

Сеттеры создаются сразу для всех атрибутов, которые пользователь (другой код) должен иметь возможность менять.

## Геттеры

Так как атрибуты класса спрятаны от прямого доступа и доступны только через методы, нам необходимы геттеры - методы, которые покажут значение конкретного атрибута конкретного класса.


Название метода традиционно выглядит как `public ТипАтрибута getАтрибут()`.

```java
public class Person {
  private int age;

  public void setAge(int age) {
    if (age < 0) {
      System.out.println("Возраст не может быть отрицательным: " + age);
      return;
    }
    this.age = age;
  }

  public int getAge() {
    return age;
  }
}
```

Геттеры создаются сразу для всех атрибутов, которые пользователь (другой код) должен иметь возможность смотреть.


# Инкапсуляция

Инкапсуляция - механизм языка, ограничивающий доступ одних компонентов программы к другим.

Слово "инкапсуляция" происходит от латинского "in capsula" — "размещение в оболочке".

Для нас инкапсуляция - написание кода таким образом, чтобы каждый класс был максимально самостоятельным и не зависел от других классов.

Его внутреннее устройство не должно никого интересовать и не должно ни на что влиять; каждый класс - "чёрный ящик" с набором кнопок (публичных методов).
