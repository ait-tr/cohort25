package array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("Bye");
        strings.add(0, "Marsel");

        List<Integer> integers = new LinkedList<>();
        integers.add(10);
        integers.add(15);
        integers.add(0, 7);

        System.out.println(strings.get(0)); // Marsel
        System.out.println(strings.get(1)); // Hello
        System.out.println(strings.get(2)); // Bye
//        System.out.println(strings.get(3));

        System.out.println(integers.get(0)); // 7
        System.out.println(integers.get(1)); // 10
        System.out.println(integers.get(2)); // 15
    }
}
