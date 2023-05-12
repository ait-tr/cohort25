import java.util.Objects;

public class Account {
  private String iban;
  private Person owner;
  private double balance;

  public Account(String iban, Person owner, double balance) {
    this.iban = iban;
    this.owner = owner;
    this.balance = balance;
  }

  public String getIban() {
    return iban;
  }

  public Person getOwner() {
    return owner;
  }

  public double getBalance() {
    return balance;
  }

  @Override
  public String toString() {
    return "Account{" +
        "iban='" + iban + '\'' +
        ", owner=" + owner +
        ", balance=" + balance +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Account account = (Account) o;
    return Double.compare(account.balance, balance) == 0 && Objects.equals(iban, account.iban) && Objects.equals(owner, account.owner);
  }

  @Override
  public int hashCode() {
    return Objects.hash(iban, owner, balance);
  }
}
