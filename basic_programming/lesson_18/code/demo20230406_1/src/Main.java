import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите имя:");
        String name = scanner.nextLine();
//        if (!name.equals("andy")) {


        char[] elements = {'j', 'l', 'k', 't', 'y', 'u'};

        if (!name.equals("andy")) {
            for (int i = elements.length - 1; i > 0; i--) {
                System.out.println(elements[i]);
            }
        } else {
            for (int i = elements.length - 1; i > 0; i--) {
                System.out.print(elements[i]+" ");
            }
        }

        /*
        1. Создаем массив
           a) сразу при создании
           b) объявляем и заполняем (циклом пробегаем и даем значение каждому эллементу),

        2. перебираем элементы  for (int i = 0; i < array.length ; i++)
        3. проверяем условие и что-то делаем с array[i] элементом




         */




    }
}