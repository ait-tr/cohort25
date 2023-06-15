package example04;

import java.io.*;
import java.net.URL;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 6/15/2023
 * cohort25
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main {

    public static void saveFile(String address) {
        try {
            System.out.println(Thread.currentThread().getName() + " начал скачивание - " + address);
            URL url = new URL(address);
            InputStream in = new BufferedInputStream(url.openStream());
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int n = 0;
            while (-1 != (n = in.read(buf))) {
                out.write(buf, 0, n);
            }
            out.close();
            in.close();
            byte[] response = out.toByteArray();

            String newFileName = Thread.currentThread().getName() + "_" + UUID.randomUUID() + ".png";
            FileOutputStream fos = new FileOutputStream("images\\" + newFileName);
            fos.write(response);
            fos.close();
            System.out.println(Thread.currentThread().getName() + " завершил скачивание - " + address);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }


    public static void main(String[] args) {
//        ExecutorService service = Executors.newFixedThreadPool(5);
        ExecutorService service = Executors.newCachedThreadPool();
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            reader // входной файл
                    .lines() // Stream строк из файла
                    .forEach(
                            address -> {
                                service.submit(() -> saveFile(address));
                            }
                    );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
