import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Task2_1 {

  // Переставить соседние элементы попарно
  // 0 1 2 3 4
  // левые индексы - 0 и 2
  // правые индексы - 1 и 3
  // пары - 0 и 1, 2 и 3
  // меняем на 1 и 0, 3 и 2
  // 1 0 3 2 4


  // 1 2 3 4 5 6
  // 2 1 4 3 6 5
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    List<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      numbers.add(Integer.parseInt(br.readLine()));
    }
    printList(numbers);

    for (int leftIndex = 0; leftIndex < numbers.size() - 1; leftIndex += 2) {
      // leftIndex - левый индекс в паре (место левого)
      // leftIndex не может быть последним индексом, только предпоследним (до (numbers.size() - 1))

      // последняя пара, если чётное количество:
      // numbers.size() - 2, numbers.size() - 1 - предпоследний и последний

      // последняя пара, если нечётное количество:
      // numbers.size() - 3, numbers.size() - 2 - предпредпоследний и предпоследний
      // последний остался без пары

      int rightIndex = leftIndex + 1; // правый индекс в паре (место правого)

      // меняем местами левый и правый
      int left = numbers.get(leftIndex);
      int right = numbers.get(rightIndex);
//      System.out.println("leftIndex = " + leftIndex + ", rightIndex = " + rightIndex);
//      System.out.printf("numbers[%d] = %d, numbers[%d] = %d%n", leftIndex, numbers.get(leftIndex),
//          rightIndex, numbers.get(rightIndex));
      numbers.set(leftIndex, right); // на место левого (leftIndex) поставили правый
      numbers.set(rightIndex, left); // на место правого (rightIndex) поставили левый
//      System.out.printf("numbers[%d] = %d, numbers[%d] = %d%n", leftIndex, numbers.get(leftIndex),
//          rightIndex, numbers.get(rightIndex));
    }

    printList(numbers);
  }

  public static void printList(List<Integer> list) {
    for (int i = 0; i < list.size() - 1; ++i) {
      System.out.print(list.get(i) + " ");
    }
    System.out.println(list.get(list.size() - 1));
  }
}
