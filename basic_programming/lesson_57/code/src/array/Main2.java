package array;

public class Main2 {
    public static void main(String[] args) {
        MyArrayList<String> strings = new MyArrayList<>();
        strings.add("Hello");
        strings.add("Bye");
        strings.add("Marsel");
        strings.add("Elena");
        strings.add("Konstantin");
        strings.add("Natalia");
        strings.add("Leoinid");
        strings.add("Elias");
        strings.add("Anna");
        strings.add("Ruslan");
        strings.addFirst("Dmitri");
        strings.set(3, "Cristian");
//        strings.add(10);

        MyArrayList<Integer> integers = new MyArrayList<>();
        integers.add(10);
//        integers.data[0] = "Hello";
//        integers.add("String");
    }
}
