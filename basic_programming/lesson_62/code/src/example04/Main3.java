package example04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 6/15/2023
 * cohort25
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main3 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);

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

        Runnable human = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " Human");
            }
        };

        service.submit(egg);
        service.submit(hen);
        service.submit(human);
    }
}
