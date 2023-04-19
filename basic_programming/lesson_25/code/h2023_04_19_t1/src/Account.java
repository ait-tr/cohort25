public class Account {
    String IBAN;
    Person owner;
    double balance;
    MyDate dateOpen;

    Account(String IBAN, Person owner, double balance, MyDate dateOpen) {
        this.IBAN = IBAN;
        this.owner = owner;
        this.balance = balance;
        this.dateOpen = dateOpen;
    }

    public String toString() {
        return "IBAN: " + IBAN +
                " Владелец:" + owner +
                " Баланс: " + balance +
                " Дата открытия счета: " + dateOpen;
    }

    public void incomeTransaction(double amount){
        balance = balance + amount;
    }
}
