/*
Задача 3
Создайте метод, который принимает в качестве параметра String - возвращает новый String.
Пусть метод переводит первые три символа в upper case (верхний регистр), а все остальные
символы в lower case (нижний регистр). Назовите метод firstToUpper.

 */
public class Main {
    public static void main(String[] args) {
        String res1= transformString("привет всем");  //ПРИвет всем
        System.out.println(res1);

        res1=transformString("ПРИВЕТ ВСЕМ"); // ПРИвет всем
        System.out.println(res1);

        res1=transformString("дЖавА эТО неслОжно!"); // ДЖАва это несложно!
        System.out.println(res1);

        res1=transformString("д"); // ДЖАва это несложно!
        System.out.println(res1);
    }

    public static String transformString(String str){
        if(str.length()>3) {
            return str.substring(0, 3).toUpperCase() + str.substring(3).toLowerCase();
        } else {
            return str.toUpperCase();
        }
    }


}