package generics.example02;

public class Main2 {
    public static void main(String[] args) {
        Nokia3310 n = new Nokia3310();
        Object o = n;
        Nokia3310 n1 = (Nokia3310) o;
    }
}
