public class Main {
    public static void main(String[] args) {
        print("Java", 5);
    }

    /*
    public static void print(String msg, int count) {
        int i = 0;
        while (i < count) {
            System.out.printf("%d. %s%n", i, msg);
            i = i + 1;
        }
    }

     */

    public static void print(String msg, int count) {
        for( int i = 0; i < count;  i++ ) {
            System.out.printf("%d. %s%n", i, msg);
        }
    }


}