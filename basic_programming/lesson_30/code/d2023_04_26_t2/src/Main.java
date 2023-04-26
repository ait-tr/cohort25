import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // узнали путь до проекта
        String filePath = new File("").getAbsolutePath();
        System.out.println(filePath);
        // создали вручную файл input.txt
        // добавили туда текст
        // кликнули на src правой кнопкой ->
        // copy Path/Reference --> path from repository root или абсолютный путь
        // /basic_programming/lesson_30/code/d2023_04_26_t2/src/input.txt
        //  FileReader() - в скобочках указываем путь до файла который хотим прочитать
        BufferedReader reader =
                new BufferedReader(new FileReader(
                        filePath + "/basic_programming/lesson_30/code/d2023_04_26_t2/src/input.txt"
                ));
        try {
            // вариант 1
            // выводим по строчке за раз вручную
//            String textLine1 = reader.readLine();
//            System.out.println(textLine1);
//            String textLine2 = reader.readLine();
//            System.out.println(textLine2);
           // вариант 2 - когда хотим сразу все строки прочитать
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line); //
            }
            // после использования reader можно закрыть методом .close()
            reader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}