import java.util.Collection;
import java.util.Comparator;

public class ComparatorAutoByYear implements Comparator<Auto> {
    //    // implements Comparator<Auto> - обязательно в треугольных скобках указать тип сравниваемых штуковин


    /* Возвращаемое значение
        0 - объект o1 равен объекту o2 из параметра
        больше 0 - объект o1 больше объекта o2 из параметра
        меньше 0 - объект o1 меньше объекта o2 из параметра

     */
    @Override
    public int compare(Auto o1, Auto o2) {
        if(o1.getYear()==o2.getYear()) return 0;
        if(o1.getYear()>o2.getYear()) return 1;
        return -1;
    }
}
