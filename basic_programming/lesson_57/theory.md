# Списки

* Коллекция, элементы которой пронумерованы по индексам.
* Добавить (в начало, в конец, по индексу)
* Удалить по индексу
* Получить по индексу
* Заменить по индексу
* Список очень похож на массив, за исключением того, что все операции уже реализованы

## Список на основе массивов и список на основе узлов

* `add(E e)` - добавить в конец
* `get(int index)` - получить по индексу
* `add(0, E e)` - добавление в начало
* `set(int index, E e` - замена элемента по индексу

## Устройство ArrayList в Java

* Добавление элемента в конец

![image](https://raw.githubusercontent.com/ait-tr/cohort25/main/basic_programming/lesson_57/img/1.png)

* Расширение массива

![image](https://raw.githubusercontent.com/ait-tr/cohort25/main/basic_programming/lesson_57/img/2.png)

```java
public class ArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10; // объем по умолчанию

    Object[] elementData; // массив с данными

    private int size; // сколько элементов содержит ArrayList

    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException(); // проверяем индекс
        return (E) elementData[index]; // возвращаем результат
    }

    public E set(int index, E element) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException(); // проверяем индекс
        E oldValue = (E) elementData[index]; // запоминаете старое значение
        elementData[index] = element; // делаете замену
        return oldValue; // возвращаете старое значение
    }

    public boolean add(E e) { // добавление
        if (size == elementData.length) {
            elementData = grow();
        }
        elementData[size] = e;
        size = size + 1;

        return true;
    }

    private Object[] grow(int minCapacity) {
        int oldCapacity = elementData.length; // запоминаем старый размер
        int newCapacity = oldCapacity >> 1; // увеличение в полтора 
        return elementData = Arrays.copyOf(elementData, newCapacity); // сразу создаем массив и копируем элементы
    }


}
```

* Какие проблемы у списка на основе массива (ArrayList)?
    - периодически нужно увеличивать размер (с полным копированием элементов) - O(n)
    - при добавлении в начало нужно сдвигать все элементы вправо - O(n)

### Устройство LinkedList

* Общая структура

![image](https://raw.githubusercontent.com/ait-tr/cohort25/main/basic_programming/lesson_57/img/3.png)

* Добавление в начало

![image](https://raw.githubusercontent.com/ait-tr/cohort25/main/basic_programming/lesson_57/img/4.png)

* Какие преимущества у связного списка (LinkedList)?
    - размер увеличивать не нужно
    - добавление в начало занимает время - O(1)