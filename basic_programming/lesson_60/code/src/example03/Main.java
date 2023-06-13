package example03;

import java.util.LinkedList;

/**
 * 6/13/2023
 * cohort25
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main {

    public static <T> MyLinkedList<T> copy(MyLinkedList<T> list) {
        MyLinkedList<T> copy = new MyLinkedList<>();
        // сделать копию ....
        return copy;
    }

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.addFirst("Anna"); //4
        list.addFirst("Konstantin"); // 3
        list.addFirst("Ruslan"); // 2
        list.addFirst("Marsel"); // 1
        list.addFirst("Dmitrii"); // 0

        list.add("Irina"); // 5
        list.add("Natalia"); // 6
        list.add("Aliona"); // 7

        System.out.println(list.get(5));
        System.out.println(list.get(6));
        System.out.println(list.get(7));

        MyLinkedList<String> copy = copy(list);


    }
}
