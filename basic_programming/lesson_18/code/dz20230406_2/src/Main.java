/*
Создайте массив из следующих элементов: "Dog", "Cat", "Monkey", "Snake".
Поменяйте местами значения между ячейкой под индексом 1 и ячейкой под индексом 3.
Вывести этот массив на экран.
 */
public class Main {
    public static void main(String[] args) {
        String[] array = createArray();
        printArray(array);
        System.out.println("--------------------------");
        swap(array,1,3);
        printArray(array);


        System.out.println("--------------------------");
        swap(array,0,2);
        printArray(array);

        System.out.println("------------- новый массив ---------");
        String[] sss  = {"jack", "john", "ann","qryw","yyyww","1"};
        printArray(sss);
        System.out.println("----------- swap(sss,5,2);");
        swap(sss,5,2);
        printArray(sss);

    }


    public static String[] swap(String[] array, int index1, int index2){
        boolean isIndex1 = index1>=0 && index1<array.length && index1!=index2;
        boolean isIndex2 = index2>=0 && index2<array.length;
        if(isIndex1 && isIndex2) {
            String temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }
        return array;
    }

   public static String[] createArray(){
        return new String[]{"Dog", "Cat", "Monkey", "Snake"};
   }
   public static void printArray(String[] array){
       //System.out.println(array);
       for (int i = 0; i < array.length ; i++) {
           System.out.printf("[%d] = %s%n", i,array[i]);
           // 0 = Dog;
           // 1 = Cat;
       }
   }
}