// Пример мутирующих и не мутирующих методов
public class Main {
    public static void main(String[] args) {
        int[] arr= {1,2,3,4};
        System.out.println("Исходный массив");
        print(arr);
        //int b[]=changeFirstElement(arr);  // мутирующий метод, b == arr
        int b[]=changeFirstElementTrue(arr); // НЕ мутирующий метод, b это новый массив
        System.out.println("Исходный массив после метода");
        print(arr);
        System.out.println("Массив результат работы метода:");
        print(b);


    }

    // метод создает копию массива
    public static int[] getCopyOfArray(int[] sourceArray){
        int[] newArray = new int[sourceArray.length];
        for (int i = 0; i < sourceArray.length; i++) {
            newArray[i] = sourceArray[i];
        }
        return newArray;
    }

    // "мутирующий" (!!!!!) метод т.е. он изменяет исходные данные,
    // исходный массив
    public static int[] changeFirstElement(int[] a){

        if(a.length>0){
            a[0]=10;
        }
        return a;
    }

    // "НЕ мутирующий" метод т.е. он НЕ изменяет исходные данные

    public static int[] changeFirstElementTrue(int[] a){
        int[] res= getCopyOfArray(a);  // получили копию исходного массива
        if(a.length>0){    // изменения
            res[0]=10;
        }
        return res;
    }



    public static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }


}
