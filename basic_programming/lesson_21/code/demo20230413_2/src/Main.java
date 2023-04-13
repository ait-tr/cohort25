import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // исходные данных

            Scanner scanner= new Scanner(System.in);
            System.out.println("Введите первое число:");
            int num1 =scanner.nextInt();
            System.out.println("Введите второе число:");
            int num2 =scanner.nextInt();

            int res=0;
            // бизнес логика
            res = div(num1, num2);

            // отображение результата
            System.out.println("Результат:");
            System.out.println(res);
        } catch (Exception e){
            System.out.println("что-то пошло не так");
        }
        System.out.println("Программа завершена");


    }

    public static int div(int num1, int num2){
        return num1/num2;
    }

}
