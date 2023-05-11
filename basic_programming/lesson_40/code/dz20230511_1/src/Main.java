/*
# Задание 1

Создайте абстрактный класс работник Employee c полями:
- база з/п - salaryBase,
- опыт  - experience

И абстрактным методом double calculateSalary().

Создайте класс ITengineer - ИТ инженер.
Реализуйте метод calculateSalary, метод должен рассчитывать зарплату с учетом опыта.
Чтобы за каждый год опыта начислялось по 5% от базовой зарплаты.
То есть метод возвращает базовую зарплату + процент надбавки.

Создайте класс QAengineer - QA инженер.
Реализуйте метод calculateSalary,
чтобы за каждый год начислялось по 6% от базы зарплаты.


Сделайте еще один метод double calculateSalary(double additionalBonus),
 чтобы за каждый год опыта начислялось по 5% от базовой зарплаты +
 размер дополнительного бонуса в процентах от базовой зп.
 */

public class Main {
    public static void main(String[] args) {
        ITEngineer e1= new ITEngineer("Jack",5000.0,10);
        QAEngineer q1= new QAEngineer("John",5000.0,10);
        System.out.println(e1);
        System.out.println(e1.calculateSalary());
        System.out.println(q1);
        System.out.println(q1.calculateSalary());
    }
}