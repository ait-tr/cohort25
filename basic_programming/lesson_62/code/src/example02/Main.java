package example02;

/**
 * 6/15/2023
 * cohort25
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main {
    public static void main(String[] args) {
        Thread eggThread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + " Egg");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) { // если обратились к потоку, который уже был завершен
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread henThread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + " Hen");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) { // если обратились к потоку, который уже был завершен
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        eggThread.start();
        henThread.start();

        try {
            eggThread.join();
            henThread.join();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " Human");
        }
    }
}
