public class Auto implements Comparable<Auto> {
    // implements Comparable<Auto> - обязательно в треугольных скобках указать тип сравниваемых штуковин
    String brand;
    int power;
    int year;




    /*
    @Override
    public int compareTo(Auto object) {
        if(this.year==object.year) return 0;
        if(this.year>object.year) return -1;
        return 1;
    }
     */

    /* Возвращаемое значение
            0 - объект this равен объекту object из параметра
            больше 0 - объект this больше объекта object из параметра
            меньше 0 - объект this меньше объекта object из параметра

         */
    @Override
    public int compareTo(Auto object) {
        if(this.power==object.power) return 0;
        if(this.power>object.power) return 1;
        return -1;
    }
/* Этот  compareTo полностью аналогичен предыдущем,
    если this.power больше o.power - результат положительное число
    если this.power меньше o.power - результат отрицательное число
    если this.power равен o.power - результат 0
    т.е. такой подход полностью соответствует Comparable, но применим только,
    если сравнение происходит по целочисленному полю!

    @Override
    public int compareTo(Auto o) {
        return this.power-o.power;
    }
*/

    public Auto(String brand, int power, int year) {
        this.brand = brand;
        this.power = power;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "brand='" + brand + '\'' +
                ", power=" + power +
                ", year=" + year +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public int getPower() {
        return power;
    }

    public int getYear() {
        return year;
    }
}
