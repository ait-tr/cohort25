import java.util.ArrayList;

/*
### Задание 2

Создайте ArrayList стрингов.
Добавьте туда произвольное число слов на ваше усмотрение.
Используя цикл, объедините все элементы в одну большую строку String
(используйте для этого промежуточную переменную "аккумулятор") и выведите получившийся результат в консоль.
Например, для ["Apple", "Orange", "Grape"] должна получится строка "AppleOrangeGrape".
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> fruits=new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Grape");

        String res="";
        for (int i = 0; i < fruits.size() ; i++) {
            res+= fruits.get(i);
        }
        System.out.println(res);

        //System.out.println(fruits);

    }
}