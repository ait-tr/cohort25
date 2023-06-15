package example03;

/**
 * 6/15/2023
 * cohort25
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main {
    public static void main(String[] args) {
        CreditCard card = new CreditCard(1000);
        Human husband = new Human("Муж", card);
        Human wife = new Human("Жена", card);

        husband.start();
        wife.start();

    }
}
