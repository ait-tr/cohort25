public class ForLoop {
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        // выведите в консоль
        // 10
        // 9
        // ...
        // 1
        // "Поехали"
        printCountDown();


    }
    public static void printCountDown(){
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            if (i == 1) {
                System.out.println("Поехали");
            }
        }
    }
}
