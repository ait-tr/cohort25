import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Task2_2 {

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
    List<Integer> numbers = new LinkedList<>();
    for (int i = 0; i < n; ++i) {
      numbers.add(Integer.parseInt(br.readLine()));
    }
    printList(numbers);

    for (int leftIndex = 0; leftIndex < numbers.size() - 1; leftIndex += 2) {
      int rightIndex = leftIndex + 1;

      int left = numbers.get(leftIndex);
      int right = numbers.get(rightIndex);
      numbers.set(leftIndex, right); // на место левого (leftIndex) поставили правый
      numbers.set(rightIndex, left); // на место правого (rightIndex) поставили левый
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
