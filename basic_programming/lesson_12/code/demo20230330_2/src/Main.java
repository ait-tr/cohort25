import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //  вызов метода getMaxNumber
        int a=5;
        int b=4;
        System.out.printf("Число 1: %d число 2: %d  большее из них: %d%n", a,b, getMaxNumber(a,b) );
        System.out.println("Большее из чисел 24 и "+a +" это число " + getMaxNumber(24,a));
        System.out.println(getMaxNumber(3+4+3, 5+1+1));

        System.out.println("..... а теперь используя Scanner: ");
        Scanner scanner= new Scanner(System.in);
        System.out.println("Введите первое целое число:");
        a= scanner.nextInt();   // прочитали первое число -> a

        System.out.println("Введите второе целое число:");
        b= scanner.nextInt();   // прочитали второе число -> b

        int result = getMaxNumber(b,a);
        System.out.printf("Число 1: %d число 2: %d  большее из них: %d%n", a,b, result );

        System.out.println( Math.max(10,20)  );

        System.out.println(" ..... а теперь три числа:");
        System.out.println("Введите первое целое число:");
        a= scanner.nextInt();   // прочитали первое число -> a

        System.out.println("Введите второе целое число:");
        b= scanner.nextInt();   // прочитали второе число -> b

        System.out.println("Введите трете целое число:");
        int c= scanner.nextInt();   // прочитали второе число -> b

        result = getMaxNumber(a,b,c);
        System.out.printf("[1]:%d%n[2]:%d%n[3]:%d%nбольшее из них: %d%n", a,b,c, result );


    }

    /*
     public static тип_результата  имя_метода ( параметры) {
          тело
          метода
     }
     */
    public static int getMaxNumber(int num1, int num2){
        return (num1>num2)? num1:num2;
    }
/*
    public static int getMaxNumber(int num1, int num2, int num3 ){
        // num1 и num2 -> x
        // x и num3

        int x = getMaxNumber(num1,num2);
        return getMaxNumber(x, num3);
    }

 */

    public static int getMaxNumber(int num1, int num2, int num3 ){ // nun1=20  num2=30  num3=7

        return getMaxNumber(getMaxNumber(num1,num2), num3);
        //     getMaxNumber(getMaxNumber(20,30), num3)
        //     getMaxNumber(30, 7)
        //     30
    }


}