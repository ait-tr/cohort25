public class Account {
    String iban;
    String nameOfOwner;
    double balance;
    Account(String iban, String nameOfOwner, double balance){
        this.iban = iban;
        this.nameOfOwner = nameOfOwner;
        this.balance = balance;
    }
    public String toString(){
        return nameOfOwner + " " + iban + " " + balance;
    }
}
