package example03;

/**
 * 6/15/2023
 * cohort25
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class CreditCard {
    private int amount;

    public CreditCard(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public boolean buy(int cost) {
        if (amount >= cost) { // если денег достаточно
            this.amount -= cost; // снимаем их с кредитки
            return true; // покупка была успешной
        } else {
            System.out.println("НЕТ ДЕНЕГ");
            return false;
        }
    }
}
