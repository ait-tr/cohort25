public class Main {
    public static void main(String[] args) {
        MyDate dateOfBirth = new MyDate(12, 04, 1989);
        System.out.println(dateOfBirth.toString());
        Person john = new Person(
                "John",
                "Malcovich",
                dateOfBirth
        );
        System.out.println(john);
        MyDate dateOfOpening = new MyDate(12, 05, 2022);
        Account johnsAccount = new Account(
                "DE82929239329",
                john,
                2000,
                dateOfOpening
        );
        Person bob = new Person(
                "Bob",
                "Oldtown",
                dateOfBirth
        );
        Account bobsAccount = new Account(
                "DE123123123123",
                bob,
                2500,
                new MyDate(20, 12, 2022)
        );
        System.out.println(bobsAccount);
        System.out.println(johnsAccount);
        Account[] accounts = {johnsAccount, bobsAccount};
        johnsAccount.incomeTransaction(3000);
        System.out.println(johnsAccount);
        for (int i = 0; i < accounts.length; i++) {
            accounts[i].incomeTransaction(5000);
        }
        System.out.println(johnsAccount);
        sendMoneyToAll(accounts);
        System.out.println(johnsAccount);
    }
    public static void sendMoneyToAll(Account[] accounts) {
        for (int i = 0; i < accounts.length; i++) {
            accounts[i].incomeTransaction(1000);
        }
    }
}