/*
Создайте массив чисел от 1 до 97.
После создания выведите все элементы массива в консоль.
 */
public class Main {
    public static void main(String[] args) {
       print(createArray());
    }

    // метод выводит массив на экран
    public static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    // метод создает массив и заполняет его значениями
    public static int[] createArray(){
        int[] array = new int[97];
        for (int i = 0; i < array.length; i++) { // проходим по массиву от 0 до array.length-1 элемента
           array[i] = i+1;  // i++ -> i=i+1      // каждому присваеваем значеение
        }
        return array;
    }
}