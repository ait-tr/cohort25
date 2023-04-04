public class Main {
    public static void main(String[] args) {
        System.out.println(sum());
        System.out.println(multiplyString("apple", 3));
    }

    //Напишите метод, который возвращает сумму чисел от - 100 до -200.
    // Метод не принимает никаких параметров. И ничего не выводит в печать.

    // for (инициализатор ; условие ; изменение) {   body  }
    public static int sum(){
        int sum = 0;
        for( int a=-100 ; a>=-102; a=a-1  ){   // a= -100 ... -101 ... -102 .... ......-200
            // body
            sum+=a;     //sum=sum+a;
        }
        return sum;
    }

    /*
    Создайте метод multiplyString, который принимает:

        String word - слово;
        int n - количество повторений.
        Метод возвращает тип String, слово повторенное n раз.
        Пример вызова метода:

        multiplyString("apple", 3); --> "appleappleapple"
        multiplyString("cat_", 7); --> "cat_cat_cat_cat_cat_cat_cat_"
        P.S. Используйте цикл, а не метод repeat

     */

public static String multiplyString(String word, int n){
    String res="";
    for(int i=1; i<=n; i++ ){
        res=res+word;
    }
    return res;

}



}