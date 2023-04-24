public class Employee {
    String firstName;
    String secondName;
    int experience;      // опыт
    String position;     // должность
    double moneyAccount; // денежный счет
    Employee(
            String firstName,
            String secondName,
            int experience,
            String position,
            double moneyAccount
            ){
        this.firstName = firstName;
        this.secondName = secondName;
        this.experience = experience;
        this.position = position;
        this.moneyAccount = moneyAccount;
    }
    public String toString(){
        return String.format("%s %s %s на счету: %.2f",
                position, secondName, firstName, moneyAccount);
    }
    public String toStringDirector(){
        return  "Director " + firstName;
    }
}
