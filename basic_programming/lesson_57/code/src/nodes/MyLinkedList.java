package nodes;

public class MyLinkedList<T> implements MyList<T> {
    private Node<T> first; // ссылка на первый элемент

    public MyLinkedList() {
        this.first = null;
    }


    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public void add(T t) {

    }

    @Override
    public void addFirst(T value) {
        Node<T> node = new Node<>(value); // создали новый узел
        if (first != null) { // если в списке уже есть элемент
            node.setNext(first); // новый узел ссылается на первый
        }
        first = node; // новый узел и есть первый
    }

    @Override
    public void set(int index, T element) {

    }
}
