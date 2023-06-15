# Проблема

![image](https://raw.githubusercontent.com/ait-tr/cohort25/main/basic_programming/lesson_55/img/1.png)

* Бывают случаи, когда общие алгоритмы и структура классов одинаковая и отличается только используемыми типами.
* Мы бы хотели избежать дублирования кода, и сделать универсальный класс для разных типов.
* Данную проблему можно решить с помощью класса `Object`, используя правило "восходящего преобразования"
* Поскольку `Object` - предок всех классов, он может хранить ссылки на любые объекты

![image](https://raw.githubusercontent.com/ait-tr/cohort25/main/basic_programming/lesson_55/img/3.png)

* При получении такого объекта нужно использовать явное преобразование к нужному типу.
* Поскольку переменной класса `Object` можно присвоить ссылку на абсолютно любой объект, у нас нет никаких гарантий, что там лежит объект нужного нам типа.

![image](https://raw.githubusercontent.com/ait-tr/cohort25/main/basic_programming/lesson_55/img/2.png)

* Мы бы хотели, сделать класс универсальным и при этом гарантировать безопасность типов.

# Generics (Обобщения, параметризованные типы)

```java
public class Cover<T> {
    private T phone;

    public Cover(T phone) {
        this.phone = phone;
    }

    public T getPhone() {
        return phone;
    }
}
```

* `<T>` - diamond-оператор. Внутри этого оператора мы указываем некоторый "тип".
* `Cover<T>` - generic-тип
* Дженерики позволяют оперировать программой в терминах неизвестных типов.
* Мы не знаем, какого типа поле `phone`, параметр конструктора `phone`, тип возвращаемого значения `getPhone`, но мы точно знаем, что это один и тот же тип.

* Разница между `Object` и `T`:
  * если вы ошиблись с типами в Object-варианте - программа запуститься, что-то успеет сделать, а потом сломается
  * если вы ошиблись с типами в `T` - программа не запуститься, не скомпилируется и вы сразу устраните ошибку.

### Самые популярные типы ошибок, которые ВЫ можете использовать

* IllegalArgumentException - неверный аргумент
* IllegalStateException - некорректное состояние
* OutOfBoundsException - выход за границы
* NoSuchElementException - отсутствует необходимый элемент