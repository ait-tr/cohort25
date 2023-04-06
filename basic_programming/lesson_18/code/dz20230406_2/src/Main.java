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

    // метод принимает массив и
    // меняет местами элемент с индексом1 с элементом с индексом2
    // возвращает этот же массив
    public static String[] swap(String[] array, int index1, int index2){
        boolean isIndex1 = index1>=0 && index1<array.length && index1!=index2; //условие правильности индекса 1
        boolean isIndex2 = index2>=0 && index2<array.length;                   //и индекса 2
        if(isIndex1 && isIndex2) {   // если индексы правильные делаем перестановку
            String temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }
        return array;
    }

    // Метод создает и возвращает массив
   public static String[] createArray(){
        return new String[]{"Dog", "Cat", "Monkey", "Snake"};
   }
    // метод принимает и выводит на экран массив
   public static void printArray(String[] array){
       //System.out.println(array);
       for (int i = 0; i < array.length ; i++) {          // перебираем по порядку элементы
           System.out.printf("[%d] = %s%n", i,array[i]);  // каждый, печатаем индекс и сам эллемент
           // [0] = Dog;
           // [1] = Cat;
       }
   }
}