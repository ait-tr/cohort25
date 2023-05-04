public class Account {
    private Person owner;
    private String iban;
    private double balance;
    private double percent;

    public Account(Person owner, String iban, double balance) {
        this.owner = owner;
        this.iban = iban;
        this.balance = balance;
    }
/*
        методы доступа к полю баланс геттеры и сеттеры
 */
    public double getBalance(){
        return balance;
    }
    public  void setBalance(double balance){
        if (balance>0) {
            this.percent=this.percent+1;
            this.balance = balance-1;
        }
    }


    @Override
    public String toString() {
        return "Account{" +
                "owner=" + owner +
                ", iban='" + iban + '\'' +
                ", balance=" + balance +
                '}';
    }
}
