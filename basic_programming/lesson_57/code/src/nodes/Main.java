package nodes;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Node<String> a1 = new Node<>("Marsel");
        Node<String> a2 = new Node<>("Ruslan");
        Node<String> a3 = new Node<>("Konstantin");
        Node<String> a4 = new Node<>("Anna");

        a1.setNext(a2);
        a2.setNext(a3);
        a3.setNext(a4);

        int i =0;
    }
}
