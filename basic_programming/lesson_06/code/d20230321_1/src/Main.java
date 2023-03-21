import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

// ------------ данные ------------------

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите объем куба: ");
        // ctrl+q - подсказка
        double volume= scanner.nextDouble();

// ------------- бизнес логика -----------------------------------------------
        double side= Math.cbrt(volume); // корень кубический
        double ceilSide = Math.ceil(side);

// ------------- отображение -------------------------------------------
        System.out.println("Объем: " +volume);
        System.out.println("сторона:" + ceilSide);

    }
}