package example01;

/**
 * 6/15/2023
 * cohort25
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main {
    public static void main(String[] args) {
        EggThread eggThread = new EggThread(); // создали объект потока
        HenThread henThread = new HenThread(); // создали объект потока

        eggThread.start(); // запускаем поток
        henThread.start(); // запускаем поток
    }
}
