package example03;

public class MyLinkedList<T> implements MyList<T> {
    private Node<T> first; // ссылка на первый элемент
    private Node<T> last; // ссылка на последний элемент

    private int count; // сколько всего элементов в списке

    public MyLinkedList() {
        this.first = null;
    }

    @Override
    public void add(T element) {
        Node<T> node = new Node<>(element); // создали узел для нового элемента
        if (first != null) { // когда в списке уже есть элементы
            this.last.next = node; // новый узел следующий после последнего
        } else { // если элементов не было
            first = node; // первый узел равен новому
        }
        last = node; // последний узел тоже равен новому
        count++;
    }

    @Override
    public void addFirst(T value) {
        Node<T> node = new Node<>(value); // создали новый узел
        if (first != null) { // если в списке уже есть элемент
            node.next = first; // новый узел ссылается на первый
        } else { // если элементов еще не было
            last = node; // последний - это новый элемент
        }
        first = node; // новый узел и есть первый
        count++;
    }

    @Override
    public T get(int index) {
        checkIndex(index);

        Node<T> current = first; // завели переменную, которая указывает на начало списка
        for (int i = 0; i < index; i++) {
            current = current.next; // переходим к следующему после текущего
        }

        return current.value;
    }

    @Override
    public void set(int index, T element) {
        checkIndex(index);

        // elements[index] = element;
        Node<T> current = first; // завели указатель на первый узел списка

        for (int i = 0; i < index; i++) {
            current = current.next; // следующий после текущего - становится текущим
        }

        // как только добежали, нужно заменить значение
        current.value = element;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }
    }

    private static class Node<E> {
        private E value; // значение любого типа, которое хранит узел

        private Node<E> next; // ссылка на следующий элемент

        public Node(E value) {
            this.value = value;
        }
    }

}
