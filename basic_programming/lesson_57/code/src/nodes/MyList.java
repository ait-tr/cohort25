package nodes;

public interface MyList<E> {
    E get(int index); // получение по индексу

    void add(E e); // добавление в конец

    void addFirst(E e); // добавление в начало

    void set(int index, E element); // замена элемента
}
