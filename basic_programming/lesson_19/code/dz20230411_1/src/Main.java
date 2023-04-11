import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Введите размер массива:");
        int n= scanner.nextInt();

        System.out.println("Введите начальное число:");
        int start = scanner.nextInt();
        int[] array = createArray(n, start);
        System.out.println(" Массив:");
        print(array);
        // умножаем на 2 и печатаем
        array = multiply(array);
        System.out.println(" Массив умножили на 2:");
        print(array);
        System.out.println(" Массив в обратном порядке:");
        printReverse(array);

        System.out.println(" Печать четных элементов массива:");
        printEven(array);


        System.out.println(" Сумма элементов массива:" + sumArray(array));
        int[] arr2={5,9,1};
        System.out.println(" Сумма элементов массива {5,9,1}:" + sumArray(arr2));

        int[] arr3={5,9,1,15,45,60,7,8};
        System.out.println(" Сумма элементов массива {5,9,1,15,45,60,7,8} которые делятся на 3 и на 5:" + sumArrayIf(arr3));

        System.out.println(" Максимальный элемент массива {5,9,1,15,45,60,7,8}" + maxNumber(arr3));


    }


/*
- Напишите метод, который создает массив размера n элементов и заполняет его целыми числами по порядку, начиная с заданного числа start
Например, при n=4 и start = 5 метод должен вернуть массив {5,6,7,8}
(n=5 , start=9) -> {9,10,11,12,13}

[0] = start
[1] = start+1
[2] = start+2
......
 */

  public static int[] createArray(int n, int start){

      int[] res = new int[n];   // создали пустой массив
      // "пробег" по массиву
      for (int i=0;i<res.length; i++){ // i от 0 до последнего элемента
         res[i]=start+i;
      }
      return res;
  }


  public static void print(int[] arr){
      for (int i=0;i<arr.length;i++){
          System.out.print("arr["+i+"]:"+arr[i] +" ");
      }
      System.out.println();
  }



    /* В коде первой задачи допишите еще 2 метода:
    - первый, который печатает массив, начиная с последнего элемента к первому
     */
    public static void printReverse(int[] arr){
        for(int i= arr.length-1; i>=0;i--){
            System.out.print("arr["+i+"]:"+arr[i] +" ");
        }
        System.out.println();
    }

    /*
- Напишите метод, который умножает каждый элемент этого массива на  2.
 */

    public static int[] multiply(int[] arr){
        for (int i=0; i<arr.length;i++){
            arr[i]*=2;
        }
        return arr;
    }

    /*
    - второй, который печатает только четные элементы массива
     */

    public static void printEven(int[] arr){
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i]%2==0){
                System.out.print("arr["+i+"]:"+arr[i] +" ");
            }
        }
        System.out.println();
    }


    /*
    Напишите метод, который принимает массив целых чисел и возвращает сумму всех элементов
     */
    public static int sumArray(int[] arr){
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];  // sum=sum+arr[i];
        }
        return sum;
    }

    /*
    Напишите метод , который считает сумму всех элементов из массива целых чисел, которые
    делятся и на 3 и на 5
     */

    public static int sumArrayIf(int[] arr){
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]%3==0 && arr[i]%5==0){
                sum+=arr[i];
            }
        }
        return sum;
    }

    /*
    Напишите метод, который возвращает самое большое число из заданного массива целых чисел.
     */
    public static int maxNumber(int[] arr){
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(maxValue<arr[i]){
                maxValue=arr[i];
            }
        }
        return maxValue;
    }

}