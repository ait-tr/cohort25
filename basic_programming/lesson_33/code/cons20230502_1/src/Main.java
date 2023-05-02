import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        /* Перенос строки
        System.out.println("Hello world");
        BufferedWriter writer = new BufferedWriter(new FileWriter("1.txt"));
        writer.write("yyyey " + System.lineSeparator());
        writer.newLine();
        writer.write("1");

         */

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter("books.txt",true));
        Book book = null;
        try {
            book = readBook(reader);
        } catch (IOException e){
            System.out.println("Ошибка при вводе книги");
        }
        reader.close();

        writeBook(writer,book);
        writer.close();


    }
    public static  Book readBook(BufferedReader reader) throws IOException {
        System.out.println("Введите автора:");
        String author= reader.readLine();
        System.out.println("Введите название");
        String title= reader.readLine();
        Genre[] genres = Genre.values();
        System.out.println("Введите жанр" + Arrays.toString(genres) + ":");
        Genre ganre= Genre.valueOf(reader.readLine());
        return new Book(author, title, ganre);
    }

    public static  void writeBook(BufferedWriter writer, Book book) throws IOException {
        writer.write(book.author+"," + book.title + ","+ book.genre.name());
        writer.newLine();
    }

}