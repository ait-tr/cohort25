import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  public static void main(String[] args) {
  // queue
    // Пример 1

    // Химчистка, которая работает по принципу FIFO
    Queue<String> laundryService = new LinkedList<>();
    laundryService.add("shirt");   // добавили рубашку
    laundryService.add("sweater"); // добавили свитер
    laundryService.add("tie");     // добавили галстук
    System.out.println(laundryService);
    // Три метода для работы с головой очереди(head):
    // Почти одинаковые, разница лишь в том, как работают с пустой очередью
    // 1. poll() возвращает, удаляет этот элемент. Если нет - null
    System.out.println(laundryService.poll());
    System.out.println(laundryService);
    // add + poll == fifo
    // 2. element() возвращает, но не удаляет. Если нет - Throws:NoSuchElementException
    System.out.println(laundryService.element());
    System.out.println(laundryService);
    // 3. peek() возвращает, но не удаляет. Если нет - null
    System.out.println(laundryService.peek());
    System.out.println(laundryService);
    laundryService.offer("trousers");
    System.out.println(laundryService);
    // можем сделать и FIFO и LIFO
    // можем добавлять и убирать с любых концов

    // Пример 2
    Deque<String> suitcase = new ArrayDeque<>();
    suitcase.add("shirt"); // добавляет справа
    suitcase.add("jeans");
    System.out.println(suitcase);
    // pollFist - c головой
    // pollLast - c концом - то последний добавленный
    System.out.println(suitcase.pollLast());
    // add + pollLast  == получаем принцип LIFO
    // add + pollFirst == получаем принцип FIFO

    // Пример 3
    // LIFO
    Deque<String> productsBag = new LinkedList<>(); // new ArrayDeque<>()
    productsBag.push("Mango"); // добавляет слева
    productsBag.push("Pasta");
    productsBag.push("Milk");
    System.out.println(productsBag);
    productsBag.pop();            // убирает слева
    System.out.println(productsBag);
    productsBag.pop();
    System.out.println(productsBag);
    productsBag.pop();
    System.out.println(productsBag);
    // push + pop == LIFO
    // LIFO или FIFI- зависит от того, какую пару методов вы используете
  }

}