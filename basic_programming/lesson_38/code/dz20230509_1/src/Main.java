/*
## 1
Создайте класс Calculator, сделайте в нем статические методы: сумма, разность и т.д.
Вызовите методы в main.
*/

public class Main {
    public static void main(String[] args) {
        System.out.println(Calculator.add(10,20));
        System.out.println(Calculator.div(10,0));
        System.out.println(Calculator.div(1,10));



        /* Можно статический метоод вызвать от объекта, НО так не делают!

        Calculator calc= new Calculator();
        System.out.println(calc.add(10,19));
        */

    }
}