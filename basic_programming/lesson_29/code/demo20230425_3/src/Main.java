import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String str1 = "55";
        String str2 = "78";

        int res=Integer.parseInt(str1) + Integer.parseInt(str2);
        System.out.println(res);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число:");
        int number =  Integer.parseInt(scanner.nextLine());
        System.out.println("Введите строку:");
        String strData= scanner.nextLine();


        System.out.println(number);
        System.out.println(strData);

        /*
           "Иванов Иван,32"
           "Васильев Михаил,37"
           "Степанов Степан,40"
         */

        String str="Степанов Степан,40";
        int pos =str.indexOf(",");
        int age= Integer.parseInt(str.substring(pos+1));
        String name = str.substring(0,pos);
        System.out.println("Возраст: " + age);
        System.out.println("Имя: " + name);




    }
}