import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
            /*
         Релиз 0
         Нужно спрашивать пользователя
         "Хотите записать еще одну умную мысль?"
         если ответ - "да"
         Спрашиваем "Какую?"
         пользователь пишет - а программа считывает его ответ и записывает в отдельный файл
         если ответ "нет", то не записываете в файл

         Релиз 1
         Сделайте так,
         программа спрашивала у пользователя бесконечно пока он не ответит "нет"
           */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter("./res/thoughts.txt", true));
        String answer1 = "да";
        while(answer1.equals("да")) {
            System.out.println("Хотите записать еще одну умную мысль?");
            answer1 = reader.readLine();
            if (answer1.equals("да")) {
                System.out.println("Какую?");
                // получили ответ - сразу записали
                writer.write(reader.readLine());
                writer.newLine();
            }
        }
        reader.close();
        writer.close();
    }
}