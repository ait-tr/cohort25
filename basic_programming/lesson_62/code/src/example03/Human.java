package example03;

/**
 * 6/15/2023
 * cohort25
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Human extends Thread {
    private final CreditCard creditCard; // кредитная карта человека

    private String name; // имя человека

    public Human(String name, CreditCard creditCard) {
        this.name = name;
        this.creditCard = creditCard;
    }

    @Override
    public void run() {
        // человек в отдельном потоке идет делать 100 покупок
        for (int i = 0; i < 100; i++) {
            synchronized (creditCard) {
                System.out.println(name + " проверяет, есть ли деньги...");
                if (creditCard.getAmount() > 0) {
                    System.out.println(name + " идет покупать");

                    if (creditCard.buy(10)) {
                        System.out.println(name + " купил!");
                    } else {
                        System.out.println(name + ": эээээээ.....");
                    }

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                } else {
                    return; // если на карте денег нет - то больше не ходим
                }
            }
        }
    }
}
