package generics.example04;

public class MyArrayList<T> {
    private static final int DEFAULT_SIZE = 10; // размер массива по-умолчанию
    private T[] elements; // массив элементов
    private int count; // количество элементов в массиве

    public MyArrayList() {
        this.elements = (T[])new Object[DEFAULT_SIZE]; // elements = new T[DEFAULT_SIZE]
        this.count = 0; // изначально элементов в массиве нет
    }
    /**
     * Добавление элемента в список
     * @param element добавляемый элемент
     */
    public void add(T element) {
        if (count == elements.length) {
            // у вас уже элементов столько, сколько в массиве места
            throw new IllegalArgumentException("Превышение размеров списка");
        }
        this.elements[count] = element;// добавляем элемент в первое свободное место
        count++;
    }

    /**
     * Получение элемента по индексу
     * @param index индекс элемента, который мы хотим получить
     * @return элемент, который стоит под индексом <code>index</code>
     */
    public T get(int index) {
        if (index >= 0 && index < count) { // если индекс корректный
            return this.elements[index];
        } else {
            throw new IndexOutOfBoundsException("Неверный индекс - " + index);
        }
    }
}
