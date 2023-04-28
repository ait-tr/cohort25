import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // можем записать в файл
        BufferedWriter writer =
                new BufferedWriter(new FileWriter("./res/output.txt", true));
//        writer.write("Всем, привет, это первая запись");
//        writer.newLine();
//        writer.write("Всем, привет, это вторая запись");
//        writer.newLine();
        for (int i = 0; i < 100; i++) {
            writer.write("Step " + i);
            writer.newLine();
        }
        writer.close();
        //
        BufferedReader reader = new BufferedReader(new FileReader("./res/output.txt"));
//        System.out.println(reader.readLine());
        String line;
        while((line = reader.readLine()) != null){
            System.out.println(line);
        }
        reader.close();
        // Попробуем получить что-нибудь и консоли и записть в файл
        // создали еще один BufferedReader, этот в отличие от предыдущего
        // будет считывать поток ввода
        BufferedReader reader1 =
                new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Как были ваши дела 28 апреля?");
        String answer = reader1.readLine();
        reader1.close();
        // Создали нового BufferedWriter потому-что закрыли предыдущий.
        BufferedWriter writer1 =
                new BufferedWriter(new FileWriter("./res/output.txt", true));
        writer1.write(answer);
        writer1.newLine();
        writer1.close();
    }
}