import services.IsPaidStatus;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 6/20/2023
 * cohort25
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main2 {
    public static void main(String[] args) {
        LocalDate dayOffDentist = LocalDate.of(2023, 6, 20).plusDays(5);
        LocalDate dayOffWater = LocalDate.of(2023, 6, 20).plusDays(7);
        IsPaidStatus status = new IsPaidStatus(false); // оплачено или нет
        IsPaidStatus status1 = new IsPaidStatus(false); // оплачено или нет
        ExecutorService service = Executors.newFixedThreadPool(1);
        // в побочном потоке работает бесконечный цикл
        service.submit(() -> {
            while (true) {
                // если сегодня день списания или день после списания и деньги не списаны
                if ((LocalDate.now().isEqual(dayOffDentist) || LocalDate.now().isAfter(dayOffDentist)) && !status.isPaid()) {
                    System.out.println("Списываем деньги...");
                    status.setPaid(true); // говорите, что уже все списали, чтобы цикл остановился
                }
                if ((LocalDate.now().isEqual(dayOffWater) || LocalDate.now().isAfter(dayOffWater)) && !status1.isPaid()) {
                    System.out.println("Списываем деньги...");
                    status.setPaid(true); // говорите, что уже все списали, чтобы цикл остановился
                }
            }
        });

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println(number);


    }
}
