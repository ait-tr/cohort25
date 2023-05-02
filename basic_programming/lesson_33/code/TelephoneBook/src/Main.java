import java.io.File;

import java.io.*;

public class Main {
    /*Задание 1
 1. Создайте новый проект(File -> New -> Project)
 1a. Назовите его TelephoneBook
 2. Внутри проекта создайте папку res
 3. Выведите сообщение для пользователя: "Желаете добавить контакт?
         Если ДА
 Далее c помощью BufferedReader получите от пользователя имя и номер телефона
 Выведите сообщение для пользователя: "Введите имя"
 Выведите сообщение для пользователя: "Введите номер"
 И запишите их в файл contacts.txt в папке res c помощью BufferedWriter
 * дополнительно сделайте вариант с циклом while или do-while,
 который бы спрашивал у пользователя контакты, пока пользователь не скажет нет.*/
    public static void main(String[] args) throws IOException {

/*        System.out.println("------------первый вариант-------------");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter("./res/contacts.txt", true));
        System.out.println("Желаете добавить контакт?");
        String answerYesOrNo = reader.readLine();
        while (!answerYesOrNo.equalsIgnoreCase("нет")) {//при вводе любого символа кроме ДА - ошибка
            //этот вариант решения у меня работает не корректно
            // точнее не так как я считаю корректно
            System.out.println("Продолжим ?");
            answerYesOrNo = reader.readLine();//срабатывает странно: если на вопрс ответить
            // не нет и не да - ввод провести позволит, а далее выбросит ошибку
            // последний ввод в текстовом файле сохраняет

            if (!answerYesOrNo.equalsIgnoreCase("нет")) {
                System.out.println("Введите имя: ");
                writer.write(reader.readLine() + "\n");
                System.out.println("Введите номер: ");
                writer.write(reader.readLine() + "\n");
            }
        }
        reader.close();
        writer.close();
*/
        System.out.println("------------второй вариант-------------");
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer1 = new BufferedWriter(new FileWriter("./res/contacts.txt", true));
        String answerYes;
        do {
            System.out.println("Желаете добавить контакт? (Да/Нет)");
            answerYes = reader1.readLine();
            if(answerYes.equalsIgnoreCase("да") || answerYes.equalsIgnoreCase("нет") ) {
                if (!answerYes.equalsIgnoreCase("нет")) {
                    System.out.println("Введите имя: ");
                    //String name = "Контактные данные: " + reader.readLine() + ", ";
                    writer1.write("Контактные данные: " + reader1.readLine() + ", ");
                    System.out.println("Введите номер: ");
                    writer1.write(" тел.: " + reader1.readLine());
                    writer1.newLine();
                }
            }
        } while (!answerYes.equalsIgnoreCase("нет"));
        writer1.close();
        reader1.close();
    }
}