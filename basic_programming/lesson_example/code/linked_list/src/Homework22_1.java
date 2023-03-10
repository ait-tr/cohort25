import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Homework22_1 {

  // Все задачи надо решить с использованием `ArrayList`. В задачах со звёздочками необходимо
  // обработать возможные исключения.
  //
  // На вход программе подается натуральное число `n` - количество чисел, а затем и сами числа,
  // каждое с новой строки.
  // Напишите программу, которая прочитает эти числа, сохранит в список, а затем выведет только
  // чётные элементы списка.
  public static void main(String[] args) throws IOException {
    List<Integer> numbers = readArrayList();

    // в массиве это было бы: int x = numbers[i];
    // for each - для каждого
    // для каждого элемента из коллекции или массива
    // для каждого x из numbers
    for (int x : numbers) {
      if (x % 2 == 0) {
        System.out.println(x);
      }
    }
  }

  public static List<Integer> readArrayList() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n; // размер списка
    try {
      n = Integer.parseInt(br.readLine());
    } catch (NumberFormatException e) {
      System.out.println("Неправильный формат числа: " + e.getMessage());
      return new ArrayList<>(); // возвращаем пустой список - не смогли прочитать размер
    }
    if (n <= 0) {
      System.out.println("Некорректный размер списка: " + n);
      return new ArrayList<>(); // возвращаем пустой список
    }
    List<Integer> list = new ArrayList<>(n); // выделяем память заранее - индексов НЕ будет,
    // но программа будет работать чуть-чуть быстрее
    while (list.size() < n) {
      try {
        list.add(Integer.parseInt(br.readLine())); // NumberFormatException
      } catch (NumberFormatException e) {
        System.out.println("Неправильный формат числа: " + e.getMessage());
      }
    }
    return list;
  }
}
