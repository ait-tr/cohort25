# Вложенные классы (Nested classes)

![image](https://raw.githubusercontent.com/ait-tr/cohort25/main/basic_programming/lesson_52/img/1.png)

* Внешние классы имеют доступ к полям вложенных классов

## Static Nested Classes (Статически вложенные, вложенные)

* Что из себя представляет? - Просто объявление одного класса внутри другого
* Обязательно с модификатором `static`
* По сути - ничего не меняется, просто один класс удобно лежит в том месте, где он используется.
* Удобно применять, если вложенный класс не используется отдельно от внешнего.
* Также может повысить инкапсуляцию (скрыть внутреннюю структуру класса)
* Общая схема работы:

```
public class OuterClass {
    public static class NestedClass {
        ...
    }
}

public static void main(String args[]) {
    OuterClass.NestedClass object = new OuterClass.NestedClass();
}
```

* Конкретно в нашей задаче:
  * Избавились от лишнего файла Pair
  * Улучшили инкапсуляцию посредством перемещения Pair внутрь Table и скрыв его от внешних воздействий
  * Повысили читаемость (классы хранятся в одном месте, убрали лишние геттеры-сеттеры)

## Внутренние классы (Inner Classes)

* В отличие от вложенных классов, ассоциированы с объектов внешнего класса.
* Внутренние классы имеют доступ к полям конкретного объекта внешнего класса.

```
public class OuterClass {
    public class InnerClass {
        ...
    }
}

public static void main(String args[]) {
    OuterClass outerObject = new OuterClass();
    OuterClass.InnerClass object = outerObject.new InnerClass();
}
```

![image](https://raw.githubusercontent.com/ait-tr/cohort25/main/basic_programming/lesson_52/img/2.png)


[Разбор проекта](https://github.com/ait-tr/cohort25/tree/main/basic_programming/lesson_52/project)