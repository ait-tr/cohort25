package example01;

/**
 * 6/13/2023
 * cohort25
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class MyLinkedList<T> implements MyList<T> {

    private Node<T> first;

    @Override
    public void add(T t) {

    }

    private static class Node<E> {
        E value;
    }
}
