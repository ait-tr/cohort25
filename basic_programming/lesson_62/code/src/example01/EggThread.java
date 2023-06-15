package example01;

/**
 * 6/15/2023
 * cohort25
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class EggThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " Egg");
        }
    }
}
