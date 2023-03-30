import java.util.Scanner;

public class H2023_03_29_t1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер месяца");
        int monthNumber = scanner.nextInt();
        switch (monthNumber) {
            case 1:
                System.out.printf(
                        "Месяц № %d это %s",
                        monthNumber,
                        "январь");
                break;
            case 2:
                System.out.printf(
                        "Месяц № %d это %s",
                        monthNumber,
                        "февраль");
                break;
            case 3:
                System.out.printf(
                        "Месяц № %d это %s",
                        monthNumber,
                        "март");
                break;
            case 4:
                System.out.printf(
                        "Месяц № %d это %s",
                        monthNumber,
                        "апрель");
                break;
            case 5:
                System.out.printf(
                        "Месяц № %d это %s",
                        monthNumber,
                        "май");
                break;
            case 6:
                System.out.printf(
                        "Месяц № %d это %s",
                        monthNumber,
                        "июнь");
                break;
            case 7:
                System.out.printf(
                        "Месяц № %d это %s",
                        monthNumber,
                        "июль");
                break;
            case 8:
                System.out.printf(
                        "Месяц № %d это %s",
                        monthNumber,
                        "август");
                break;
            case 9:
                System.out.printf(
                        "Месяц № %d это %s",
                        monthNumber,
                        "сентябрь");
                break;
            case 10:
                System.out.printf(
                        "Месяц № %d это %s",
                        monthNumber,
                        "октябрь");
                break;
            case 11:
                System.out.printf(
                        "Месяц № %d это %s",
                        monthNumber,
                        "ноябрь");
                break;
            case 12:
                System.out.printf(
                        "Месяц № %d это %s",
                        monthNumber,
                        "декабрь");
                break;
            default:
                System.out.println(
                        "На Земле нет такого месяца"
                );
                break;
        }
    }
}
