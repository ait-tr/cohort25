package example04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 6/15/2023
 * cohort25
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main2 {
    public static void main(String[] args) {
//        ExecutorService service = Executors.newFixedThreadPool(2);

        Runnable egg = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " Egg");
            }
        };

        Runnable hen = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " Hen");
            }
        };

        Thread t1 = new Thread(egg);
        Thread t2 = new Thread(hen);

        t1.start();
        t2.start();

    }
}
