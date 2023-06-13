## 01. Нюансы работы с Generics

Два контекста работы с Generics

### Первый контекст - объявление 

* Объявляем собственный Generic-тип - вы можете использовать любую букву или даже слово
* Мы в этот момент времени не знаем точно, какой тип будет вместо placeholder.

```
class MyLinkedList<T> {
    // ...
}
```

```
static class Node<E> {
    // ...
}
```

```
interface MyList<V> {
    // ...
}
```

### Второй контекст - использование

* Когда мы используем уже написанный Generic-тип
* В этот момент мы точно знаем, какой тип туда нужно подставить

```
List<Integer> integers = new LinkedList<>();
ArrayList<String> strings = new ArrayList<>();
```

* Когда какой-либо тип реализует или наследует Generic
* Тут мы уже указываем ту букву, которая указана слева при объявлении типа

```
... implements MyList<T>
```

```
public void add(T b) {

}
```

```
private Node<E> first;
```

### Заключение

* Когда объявляем - ставим любую букву
* Когда используем - ту, которая была указана ранее

### Оберточные типы

* `Wrappers` - классы-обертки, которые хранят в себе значение примитивного типа.

```
class Integer {
    private int value;
    
    public Integer(int value) {
        this.value = value;
    }
}

class Character {
    private char value;
    
    public Character(char value) {
        this.value = value;
    }
}
```

* В Java есть механизм, который умеет автоматически оборачивать примитивные типы в ссылочные - autoboxoing
* И обратно - autounboxing

* Посмотрим bytecode класса CoverObject:

```
public class example02/CoverObject {

  private Ljava/lang/Object; phone
}
```

* Посмотрим на bytecode класса Cover<T>:

```
// declaration: example02/Cover<T>
public class example02/Cover {

  private Ljava/lang/Object; phone
}
```

* С точки зрения виртуальной машины, что Cover с Object-ом, что Cover<T> - это и то же
* После компиляции буква T везде заменяется на Object - стирание типов
* Generics - нужны для человека, чтобы человек не ошибся.
* Компилятор проверяет, что вы используете Generic-корректно (вместо строки не положили число), а потом убирает Generic и заменяет на Object
* Поскольку <T> заменяется на Object, а Object - это ссылочный тип, вы не можете указать <int>, потому что <int> - примитивный
* В Object можно преобразовать из Integer (потомок Object)

## Ответ на вопрос:

* Почему в Java используются обертки в Generics?

* Потому что Generics<T> посредством стирания типов заменяются на ссылочный Object.
* Поскольку ссылочные типы отличаются от примитивных, мы должны сначала превратить примитивный в ссылочный (boxing)
* Затем преобразовать ссылочный тип-обертку в Object

### Сравнение LinkedList и ArrayList

* `ArrayList`
  * Быстрый на получение элемента по индексу
  * Требует периодического увеличения памяти
  * Медленный на добавление в начало
* `LinkedList`
  * Не требует увеличения памяти
  * Быстрый на добавление в начало/конец
  * Медленный на получение элементов по индексу


### Разбор реализации `LinkedList` в Java

* В Java `LinkedList` - двунаправленный список

```
public class LinkedList<E> implements List<E> {
    Node<E> first; // ссылка на первый элемент
    Node<E> last; // ссылка на последний элемент
    
    private static class Node<E> {
        E item; // значение узла
        Node<E> next; // ссылка на следующий
        Node<E> prev; // ссылка на предыдущий
        // ...
    }
    
    public boolean add(E e) { // добавление в конец
        linkLast(e); // присоединить последний
        return true;
    }
    
    void linkLast(E e) {
        final Node<E> l = last; // запоминаем последний узел в переменную l
        final Node<E> newNode = new Node<>(l, e, null); // создают новый узел, который в качестве предыдущего содержит послений
        last = newNode; // теперь последний - это новый узел
        if (l == null) // если список был пустой
            first = newNode; // первый узел и последний - одно и то же
        else
            l.next = newNode; // если не пустой - то новый узел идет сразу после последнего
        size++;
    }
    
     public E get(int index) { // получение элемента по индексу
        checkElementIndex(index);
        
        if (index < (size / 2)) { // смотрим, меньше середины
            Node<E> x = first; // начинаем с начала
            for (int i = 0; i < index; i++) // идем к нужному индексу вправо
                x = x.next; // переходим к след
            return x.item;
        } else {
            Node<E> x = last; // если дальше середины - начинаем с конца
            for (int i = size - 1; i > index; i--) // идем к нужному индексу влево
                x = x.prev; // переходим к пред
            return x.item;
        }
    }
   
}
```

### Заключение

* `LinkedList` хорошо применять, когда нужно много раз добавлять в начало и конец (стеки и очереди)
* Во всех остальных случаях используем `ArrayList`
* `ArrayList` работает на основе "нативных"-функций (копирование и сдвиги в массивах) - эти операции очень быстрые
* Поэтому на практике в 99% используют `ArrayList`
* Любая сортировка или поиск - `ArrayList`
* Josh Bloch - `Если подумаете, что сделали что-то зря, то подумайте о том, что я написал LinkedList и ни разу им не воспользовался`

### Повторить 

* lambda (на реальных примерах)
  * Try-catch
  * побитовые операции
  * классы, вложенные классы (на реальных примерах), static
  * итераторы
  * Stream API
  * Threads
  * Method Reference