import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Homework22_0 {

  // Все задачи надо решить с использованием `ArrayList`. В задачах со звёздочками необходимо
  // обработать возможные исключения.
  //
  // На вход программе подается натуральное число `n` - количество чисел, а затем и сами числа,
  // каждое с новой строки.
  // Напишите программу, которая прочитает эти числа, сохранит в список, а затем выведет только
  // чётные элементы списка.
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    List<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      numbers.add(Integer.parseInt(br.readLine()));
    }

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
}
