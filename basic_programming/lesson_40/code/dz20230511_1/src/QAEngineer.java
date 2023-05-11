public class QAEngineer extends Employee{
    private final int BONUS_FOR_EXPERIENCE=6;
    public QAEngineer(String name, double salaryBase, int experience) {
        super(name, salaryBase, experience);
    }

    @Override
    public double calculateSalary() {
        return getSalaryBase() + getSalaryBase()*(BONUS_FOR_EXPERIENCE*0.01 * getExperience());
    }

    @Override
    public String toString() {
        return "QAEngineer" + super.toString() + "Bonus for experience: " + BONUS_FOR_EXPERIENCE;
    }
}
