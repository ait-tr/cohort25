/*
Задача 1 с возможностью выбора варианта поведения
в зависимости от имени пользователя
// о пользе методов
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите имя:");
        String name = scanner.nextLine();
        if (!name.equals("andy")) {
            char[] array = createArray(); //
            reversePrintArray(array);
        } else {
            char[] array = createArray2(); //
            reversePrintArray2(array);
        }
    }

    //createArray - создать массив
    //reversePrintArray - печатает массив в обратном порядке
    public static char[] createArray(){
        char[] arr = {'j', 'l', 'k', 't', 'y', 'u'}; // краткая форма
        return arr;
    }

    public static char[] createArray2(){
        char[] arr = {'j', 'l', 'k', 't'}; // краткая форма
        return arr;
    }
    public static void reversePrintArray(char[] arr1){
        for(int i=arr1.length-1; i>=0; i--){
            System.out.print(arr1[i]+" ");
        }
        System.out.println();
    }

    public static void reversePrintArray2(char[] arr1){
        for(int i=arr1.length-1; i>=0; i--){
            System.out.println(arr1[i]+" ");
        }
        System.out.println();
    }
}

        /*
        1. Создаем массив
           a) сразу при создании
           b) объявляем и заполняем (циклом пробегаем и даем значение каждому эллементу),

        2. перебираем элементы  for (int i = 0; i < array.length ; i++)
        3. проверяем условие и что-то делаем с array[i] элементом




         */



