import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое число");
        int x;
        try {
            x = scanner.nextInt();
        } catch(Exception e){
            System.out.println("Что-то пошло не так");
            e.printStackTrace(); // вывести ее в консоль
            x = 0;
        }
        System.out.println(x);
        System.out.println("Конец программы");
    }
}