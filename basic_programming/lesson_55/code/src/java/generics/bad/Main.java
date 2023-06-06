package generics.bad;

public class Main {
    public static void main(String[] args) {
        Human marsel = new Human();
        marsel.go();

        Programmer programmer = new Programmer();
        programmer.go();
        programmer.runFromPolice();
    }
}
