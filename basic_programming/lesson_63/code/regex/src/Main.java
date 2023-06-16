import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  public static void main(String[] args) {
    // regex
    String text = "Morning is the hardest time of the day";
    // Допустим мы знаем конкретное слово и хотим его заменить
    // тогда нам не нужны regex или regexp - regular expression
    String text2 = text.replaceAll("Morning", "Evening");
    System.out.println(text2);
    // если мы точно, что именно стоять например Morning или Noon
    // мы можем использовать регулярное выражение
    // через | можно перечислять разные подходящие варианты
    String text3 = text.replaceAll("Morning|Noon", "Evening");
    System.out.println(text3);
    //
    String text4 = "Cat is an enemy of rat";
    String text5 = text4.replaceAll("Cat|rat", "hamster");
    System.out.println(text5);
    // если не знаю какая первая буква, могу заменить только ее
    // [Cr] Первая буква это либо C, либо r
    // [Cr9h] Первая буква это либо C, либо 9, либо h
    String text6 = text4.replaceAll("[Cr]at", "hamster");
    System.out.println(text6);

    String text7 = "Cat in the hat is an enemy of the rat who is fat";
    // заменим Cat и hat
    String text8 = text7.replaceAll("[Ch]at", "REPLACED");
    System.out.println(text8);
    // есть значок "." - подходит вместо любого символа
    // заменятся все четыре слова
    String text9 = text7.replaceAll(".at", "REPLACED");
    System.out.println(text9);
    // Допустим мы хотели бы заменить только слово,
    // подходящее под описание выше,
    // но слово стоящее в начале фразы
    // Заменить слово из начала фразы
    // ^ - это обозначения начала строки
    String text10 = text7.replaceAll("^.at", "REPLACED");
    System.out.println(text10);
    // есть такой же символ, но для конца - то есть слово стоящее в конце
    // $ - обозначает конец строки
    String text11 = text7.replaceAll(".at$", "REPLACED");
    System.out.println(text11);
    //
    String text12 = "North Korea is enemy of democracy in all the North";
    // заменить только первое слово North на South
    // слово enemy нужно заменить на слово friend
    // слово democracy заменить на слово free world
    // последнее слово the North заменить на countries
    // South Korea is friend of free world in all countries.
    String example = text12.replaceAll("apple", "orange")
        .replaceAll("fruit", "vegetable");
    String text13 = text12.replaceAll("^North", "South")
        .replaceAll("enemy", "friend")
        .replaceAll("democracy", "free world")
        .replaceAll("the ", "")
        .replaceAll("North$", "countries");
    System.out.println(text13);
    // с помощью [] указать диапазон из нескольких значений
    // [Agh] - любая буква из перечисленных
    // Диапазон можно задать через тире
    // [A-Z] - любая большая буква латинского
    // [a-z] - любая маленькая буква латинского
    // [A-Za-z] - любая большая или маленькая буква латинского
    // [А-я] - буквы русского
    String text14 = "It feels like rain";
    // заменю любое слово у которого в середине "ik"
    String text15 =
        text14.replaceAll("[A-Za-z]ik[A-Za-z]", "as");
    // одна скобка == одна буква
    System.out.println(text15);
    //
    String text16 = "Rat fat hat cat";
    // любый слова кроме тех которые начинаются на букву f
    String text17 = text16.replaceAll("[^f]at", "Replaced");
    System.out.println(text17);
    // если ^ внутри квадратных скобок, то это не начало строки, а отрицание
    // [^abc] - любой символ, кроме a, b, c

    // Если нужно слово из трех букв, не цифр
    // "[A-Za-z][A-Za-z][A-Za-z]" - ужасно длинная штука
    // \w - [A-Za-z_0-9] - word characters  - только для латинских
    // \s - whitespace characters - пробельные символы
    // \d - [0-9] - digit - числовой символ - цифра

    // Тоже самое но с отрицанием:
    // \W - [^A-Za-z0-9_] - не буквенные не чисесльны
    // \S - whitespace characters - не пробельные
    // \D - [0-9] - не цифры - все, кроме этих 10 цифр - любые другие

    String text18 = "Cat cat 878 cat rat";
    String text19 = text18.replaceAll("\\d\\d\\d", "snake");
    String text20 = text18.replaceAll("\\w\\w\\w", "snake");
    String text21 = text18.replaceAll("[A-Za-z][A-Za-z][A-Za-z]", "snake");
    System.out.println(text19);
    System.out.println(text20);
    System.out.println(text21);
    // если нужно что-то повторить в фигурных скобках
    String text22 = text18.replaceAll("[A-Za-z]{3}", "snake");
    System.out.println(text22);
    // замени все слова у которых четыре буквы и 2 числа, например lake99
    // "[A-Za-z]{4}\\d{2}"
    String text23 = "apple225 cat_78 or989 sweet potato";
    // 1 замените только apple225 на "first"
    // 2 замените только cat_78 на "second"
    // 3 замените только or989 на "third"
    // 3 замените только sweet potato на "final"
    String text24 = text23.replaceAll("^\\w{8}", "first");
    System.out.println(text24);

    String text25 = text23.replaceAll("\\w{3}_\\d{2}", "second");
    System.out.println(text25);

    String text26 = text23.replaceAll("\\s[A-Za-z]{2}\\d{3}", "\sthird");
    System.out.println(text26);

    String text27 = text23.replaceAll("[A-Za-z]{5}\\s[A-Za-z]{6}", "final");
    System.out.println(text27);

    String text28 = "leap  leap appleapple apple";
    // нужно заменить последнее.
    // \b - word boundary - как $ или ^ - но для границы слова
    // границей может выступать любой символ \W
    String text29 = text28.replaceAll("\\bapple\\b", "stub");
    System.out.println(text29);

    String text30 = text28.replaceAll("\\bleap\\b", "REPLACED");
    System.out.println(text30);
    // cлово leap внутри  appleapple осталось нетронутым
    // apple
    // Captured groups - пойманные группы
    // с помощью круглых скобок мы можем
    // объединять и использовать фрагменты
    String text31 = "Cats and rats are lifetime friends";
    // хочу добавить слева и справа "--"
    String text32 = text31.replaceAll("([Cr]ats)", "--$1--");
    System.out.println(text32);
    // вместо флага $1 подставляется выражение слева из скобок

    String text33 = "ivan@gmail.com";
    // -> Имя: Иван Почта: gmail Домен: com
    String text34 = text33.replaceAll(
        "(\\w{4})@(\\w{5}).(\\w{3})", "Имя: $1 Почта: $2 Домен: $3");
    System.out.println(text34);

    // Quantifiers
    // если мы знаем сколько символов нужно то указываем в фигурных скобках число
    // "\\w{4}"
    // А если не знаем как быть?
    // для это существуют специальные символы:
    // * - ноль или более вхождений
    // + - одно или более вхождений
    String text35 = "ivan@gmail.com galya@gmail.com sigizmund@gmail.com @gmail.com";
    String text36 = text35.replaceAll("\\w+@gmail.com", "REPLACED");
    System.out.println(text36);

    String text37 = text35.replaceAll("\\w+@", "REPLACED");
    System.out.println(text37);

    String text38 = text35.replaceAll("\\w*@gmail.com", "REPLACED");
    System.out.println(text38);

    String text39 = text35.replaceAll("\\w+(@)", "REPLACED$1");
    System.out.println(text39);

    // Проверка содержится ли такой элемент или нет
    Pattern pattern = Pattern.compile("\\w+@\\w+.\\w+");
    // есть ли такой правильный имейл среди имейлов?
    Matcher matcher = pattern.matcher("cat@mail.org dog@gmail.com");
    boolean hasCorrectOne = matcher.find();
    System.out.println(hasCorrectOne); // true
    // cat@.org @gmail.com   - для такого было бы false


    // Если нужно проверить совпадает ли одно конкретное слово с шаблоном
    // можно воспользоваться методом matches
    String email1 = "@gmail.com";
    String email2 = "dog@gmail.com";
    boolean res1 = email1.matches("\\w+@\\w+.\\w+");
    boolean res2 = email2.matches("\\w+@\\w+.\\w+");
    System.out.println(res1);
    System.out.println(res2);






  }
}