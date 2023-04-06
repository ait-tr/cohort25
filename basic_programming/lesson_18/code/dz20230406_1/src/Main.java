/*
Создайте массив char со следующими элементами: 'j', 'l', 'k', 't', 'y', 'u'.
Выведите элементы в консоль в обратном порядке.
(Внимание! В обратном порядке - это от последнего элемента к первому )
 */

import java.util.Scanner;

/*
       char[] arr = new char[]{'j', 'l', 'k', 't', 'y', 'u'};  // полная форма создания массива
       char[] arr = {'j', 'l', 'k', 't', 'y', 'u'};           // краткая форма
 */
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