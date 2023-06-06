package generics.example04;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> integers = new MyArrayList<>();
        integers.add(7);
        integers.add(10);
//        integers.add("Hello");
        integers.add(77); // не можете добавить строку, потому что список Integer

        int value1 = integers.get(0);
        int value2 = integers.get(1);
        int value3 = integers.get(2);

        System.out.println(value1 + " " + value2 + " " + value3);

        MyArrayList<String> strings = new MyArrayList<>();
        strings.add("Hello");
        strings.add("Bye");
        strings.add("Marsel");
//        strings.add(77);

        String s1 = strings.get(0);
        String s2 = strings.get(1);
        String s3 = strings.get(2);
        System.out.println(s1 + " " + s2 + " " + s3);
    }
}
