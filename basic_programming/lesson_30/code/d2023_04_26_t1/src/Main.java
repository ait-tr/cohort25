import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args)  {
        // BufferedReader как и Scanner позволяет считывать
        // информацию, введенную пользователем в консоль
        //
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        //
        System.out.println("Введите имя");
        String answer = "";
        try {
            // метод readLine() выбрасывает ошибку IOException
            // поэтому либо оборачиваем в try catch
            // либо указываем вверху throws IOException
            answer = reader.readLine();
            System.out.println(answer); // "3"
        } catch (IOException e) {
            // если укажем тип Exception - то будут обрабатываться любые ошибки
            e.printStackTrace();
        }
        System.out.println(answer);
        //
        //
        // Создайте класс клиент с полями:
        // - name;
        // - age;
        // boolean isGym; - это поле показывает, что абонемент в тренажерный зал
        // если оно false - то в бассейн
        // если оно true - то в тренажерный зал

        // Создайте в main HashMap<String, Client> - то есть ключ email : значение client
        // и наполните значениями

        // Создайте метод public static void greet(HashMap<String, Client> map, String email) -
        // выводит в консоль приветствие в следующей форме:
        // Добро пожаловать, <имя>! Хорошего занятия в <бассейне | зале>

        // Создайте метод public static void greet2(HashMap<String, Client> map) -
        // выводит в консоль приветствие в следующей форме:
        // пользователь вводит имейл в консоль
        // Добро пожаловать, <имя>! Хорошего занятия в <бассейне | зале>
        HashMap<String, Client> clientsMap = new HashMap<>();
        clientsMap.put("pohgrebnyak@mail.com",
                new Client("Alexander", 45, true));
        clientsMap.put("glazunov@mail.com",
                new Client("Igor", 45, false));
        clientsMap.put("vasnecov@mail.com",
                new Client("Anton", 45, true));
        System.out.println(clientsMap);
        greet(clientsMap, "vasnecov@mail.com");
        greet(clientsMap, "glazunov@mail.com");
        try {
            greet2(clientsMap);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void greet(HashMap<String, Client> map, String email){
        Client client = map.get(email);
        System.out.println("Добро пожаловать " + client.name + "! ");
        System.out.println("Хорошего занятия в " + (client.isGym ? "зале":"бассейне") );

    }
    public static void greet2(HashMap<String, Client> map) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Скажите email");
        String email = reader.readLine();
        Client client = map.get(email);
        System.out.println("Добро пожаловать " + client.name + "! ");
        System.out.println("Хорошего занятия в " + (client.isGym ? "зале":"бассейне") );
    }

}