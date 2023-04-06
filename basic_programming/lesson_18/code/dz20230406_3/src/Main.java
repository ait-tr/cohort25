/*
Создайте массив чисел от 1 до 97.
После создания выведите все элементы массива в консоль.
 */
public class Main {
    public static void main(String[] args) {
       print(createArray());
    }

    public static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int[] createArray(){
        int[] array = new int[97];
        for (int i = 0; i < array.length; i++) {
           array[i] = i+1;  // i++ -> i=i+1
        }
        return array;
    }
}