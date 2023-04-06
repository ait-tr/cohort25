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
        char[] array = createArray(); //
        reversePrintArray(array);
    }

    //createArray - создать массив
    public static char[] createArray(){
        char[] arr = {'j', 'l', 'k', 't', 'y', 'u'}; // краткая форма инициализации массива
        return arr;
    }

    //reversePrintArray - печатает массив в обратном порядке
    public static void reversePrintArray(char[] arr1){
        for(int i=arr1.length-1; i>=0; i--){    // i от последнего индекса до нулевого
            System.out.print(arr1[i]+" ");
        }
        System.out.println();
    }

}