import java.util.Scanner;

public class h2023024_2 {
    public static void main(String[] args) {

//        a.
//                Пользователь вводит с клавиатуры IBAN в виде строки (Например так: DE2334923291). Программа проверяет, что счет корректный, т.е.
//                - длина составляет 12 символов
//                - начинается на "DE"
//
//        b.
//                Если после DE следует "2334" (это значение должно быть заданно в программе как переменная) программа должна выдать сообщение:
//        "счет клиента №923291 в нашем банке" ( №923291 - оставшиеся цифры счета).
//        Если после DE следует что то другое, то программа должна выдать сообщение "введенный счет из другого филиала"
//        Например:
//                - DE2334923291  -> счет клиента №923291 в нашем банкке
//                - G2334923291  -> некорректный номер счета
//                - DE23349232916843  -> некорректный номер счета
//                - DE5554923291  -> введенный счет из другого филиала
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите IBAN");
        //
        // trim() - убирает пробелы с начала и конца строки и возвращает обрезанную строку
        String iban = scanner.nextLine().trim();
        String example = "  Cake ".trim();  // "Cake"
        // часть а

        String country = iban.substring(0, 2);
        boolean hasLengthTwelve = iban.length() == 12;
        boolean isGerman = country.equalsIgnoreCase("DE");

        if (hasLengthTwelve && isGerman) {
            String department = iban.substring(2, 6);
//            System.out.println(department);
            boolean isRightFilial = "2334".equals(department);
            String clientAccount = iban.substring(6);
            if (isRightFilial) {
                System.out.println("счет клиента №" + clientAccount + " в нашем банке");
            } else {
                System.out.println("Введенный счет из другого филиала");
            }
        } else {
            System.out.println("Некорректный iban");
        }
        // часть b

    }
}
