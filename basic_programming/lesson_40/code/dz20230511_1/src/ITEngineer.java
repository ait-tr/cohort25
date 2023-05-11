public class ITEngineer extends Employee{
    private final int BONUS_FOR_EXPERIENCE=5;


    public ITEngineer(String name, double salaryBase, int experience) {
        super(name, salaryBase, experience);
    }

    @Override

    //  1000 + 1000/100*5  * expr  == 1000 + 1000 *  (0,01*5)  * expr
    public double calculateSalary() {
        return getSalaryBase() + getSalaryBase()*(BONUS_FOR_EXPERIENCE*0.01 * getExperience());
    }

    @Override
    public String toString() {
        return "ITEngineer" + super.toString() + "Bonus for experience: " + BONUS_FOR_EXPERIENCE;
    }
}
