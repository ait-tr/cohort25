package examples;

public class MainExceptionWithStackTrace {

    public static int div(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {
        int x = 10;
        int y = 0;
        int c = div(x, y);
        System.out.println(c);
    }
}
