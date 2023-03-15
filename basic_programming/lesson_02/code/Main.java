public class Main {
    public static void main(String[] args) {
        System.out.println("Всем доброе утро!");
        //System.out.println("Меня зовут Алишер");
        System.out.print("Сейчас мы приступим \nк разбору домашнего задания\n");
        System.out.print("\tВот-вот приступим");
    /*
    Очень важное сообщение, оно касается всех без исключения
    Еще одно сообщение:)
    */
        System.out.println("Очень хочу ответить на ваш вопрос");
        System.out.println("Но для этого нужно подготовиться");
        System.out.println("Строчные комментарии удобно использовать для кода, особненно с горячими калваишами контр или комманд и \\");
        System.out.println("Привет я хочу увидеть кавычку в консоли \" ");
        // Привет я властелин ", мне подчиняются также '
        // И даже \ и / меня боятся. И не хотят иметь со мной дел.

        // Это нужно сделать c print без ln
        System.out.print("Привет я властелин \", мне подчиняются также ' \n ");
        System.out.print("И даже обычные \\ и / меня боятся. И не хотят иметь со мной дел. \n");
        // Экранируем обратный слэш \ и "
        // У нас есть еще перенос строки \n и отсуп \t
        // Как на увидеть в консоли \\
        System.out.println("\\\\");

        // Переменные
        // ТипДанных имя = значение;
        String text = "Добро пожаловать в мир Java.";
        // равно "=" - оператор присваивания
        System.out.println(text);

        String text2 = "Блины хороши к масленице.";
        System.out.println(text2);
        // сделаем переменную типа int - т.е. целое число
        // именем number и значение равным 12
        int number = 12;
        System.out.println(number);
        int x = 10;
        int y = 14;
        System.out.println(x+y);
        int sum = x + y;
        System.out.println(sum);

        // выделяю место в памяти для переменной - декларация или объявление
        // мы указываем тип и имя
        int c;
        // присваивание значения - инициализацией
        c = 289; // записали туда значение
        System.out.println(c);
        c = 300;
        System.out.println(c);
        // Код ниже вызовет ошибку
        // int c = 400; // ошибка
        // мы продекларировать значение только один раз - при первом появлении

        // Задание: сделайте переменную для своего возраста
        // Сделайте переменную для вашего имени;
        // Сделайте переменную для вашей фамилии;
        // и выведите все это в консоль в форме: Имя Фамилия 29 лет
        // если объединяем строку и число через + - получается строчный тип
        System.out.println(x + " " + text + " еще какое-то слово");

        int age = 62;
        String firstName = "Ivan";
        String secondName = "Borisov";
        System.out.println(firstName + " " + secondName + " " + age + " лет");

        // camelCase - будем использовать
        String myBeautifulCat = "Leru";
        // kebab-case  - не используем пока что, встретим в css
        String my-beatiful-hamster = "Homa";
        // snake_case
        String my_beautiful_panda = "Po";
        // SCREAMING_SNAKE_CASE - используется для констант в java
        String MY_BEAUTIFUL_PONNY = "Tolik";


    }