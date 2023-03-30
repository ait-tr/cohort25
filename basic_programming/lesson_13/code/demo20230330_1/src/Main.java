// тернарный оператор
public class Main {
    public static void main(String[] args) {
        int choice = 0;
        System.out.println("Операция " + ((choice == 0) ? "не " : "") + "завершилась");

        if (choice == 0) {
            System.out.println("Операция не завершилась");
        } else {
            System.out.println("Операция завершилась");
        }



    }

}