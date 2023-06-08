package array;

public class MyArrayList<E> implements MyList<E> {
    private static final int DEFAULT_SIZE = 10; // размер массива по умолчанию

    private Object[] data; // массив, может хранить элементы любого типа
    private int size; // фактическое количество элементов

    public MyArrayList() { // конструктор
        this.data = new Object[DEFAULT_SIZE]; // выделяем память на 10 элементов
    }

    @Override
    public E get(int index) { // получение элемента по индексу
        checkIndex(index);
        return (E)data[index]; // преобразование гарантировано выполняется, потому что в data только E
    }

    @Override
    public void add(E e) { // добавляем элемент в конец
        ensureSize(); // проверяем размер массива и если нужно увеличиваем

        this.data[size] = e; // добавляем элемент
        size = size + 1; // size++ увеличиваем количество элементов
    }
    private void grow() { // увеличение массива в полтора раза
        int oldLength = data.length; // запоминаем старый размер
        int newLength = oldLength + oldLength / 2; // новая длина - в полтора раза больше

        Object[] newData = new Object[newLength]; // создали новый массив большей длины

        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i]; // копируем все элементы из старого массива в новый
        }

        this.data = newData; // забываем старый массив и работаем только с новым
    }

    @Override
    public void addFirst(E e) { // добавление в начало
        ensureSize(); // обеспечиваем нужный размер

        for (int i = size; i > 0; i--) { // проходим по всем элементам
            this.data[i] = this.data[i - 1]; // сдвиг вправо
        }

        this.data[0] = e; // кладем элемент в начало
        size++; // увеличиваем количество элементов
    }

    @Override
    public void set(int index, E element) {
        checkIndex(index);

        this.data[index] = element;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) { // проверяем корректность индекса
            throw new IndexOutOfBoundsException("Incorrect index - " + index);
        }
    }

    private void ensureSize() { // обеспечить размер
        if (this.size == data.length) { // массив переполнен
            grow(); // увеличиваем массив
        }
    }
}
