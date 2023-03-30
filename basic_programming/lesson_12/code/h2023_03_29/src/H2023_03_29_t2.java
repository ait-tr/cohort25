import java.util.Scanner;

public class H2023_03_29_t2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название месяца");
        String month = scanner.nextLine().toLowerCase();
        switch (month) {
            case "декабрь":
            case "январь":
            case "февраль":
                System.out.printf("%s - это %s", month, "зима");
                break;
            case "март":
            case "апрель":
            case "май":
                System.out.printf("%s - это %s", month, "весна");
                break;
            case "июнь":
            case "июль":
            case "август":
                System.out.printf("%s - это %s", month, "лето");
                break;
            case "сентябрь":
            case "октябрь":
            case "ноябрь":
                System.out.printf("%s - это %s", month, "осень");
                break;
            default:
                System.out.println("Ошибка, некорректное название месяца");
        }

    }
}
