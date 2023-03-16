import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите день (1-31): ");
        int day=scanner.nextInt(); // прочитать число int c клавиатуры
        System.out.println("Введите месяц (1-12): ");
        int month= scanner.nextInt(); // прочитать еще одно число int c клавиатуры
        System.out.println("Введите год: ");
        int year= scanner.nextInt();
        System.out.println("Введите раазделитель:");
        String delimiter=scanner.next();  // прочитать строковое значение

//--------------------------------------------------------------
        System.out.println(day+delimiter+month+delimiter+year);
        System.out.println(13-10);

    }
}