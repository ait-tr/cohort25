# Параметризованные тесты

Если код (и смысл результата) теста полностью повторяется, отличаясь только входными значениями, то для повтора теста с разными наборами данных можно использовать параметризацию.

Для параметризованного теста необходимо использовать аннотацию [`@ParametrizedTest`](https://junit.org/junit5/docs/current/api/org.junit.jupiter.params/org/junit/jupiter/params/ParameterizedTest.html) вместо `@Test`.

Для передачи параметров достаточно удобно использовать [`@CsvSource`](https://junit.org/junit5/docs/current/api/org.junit.jupiter.params/org/junit/jupiter/params/provider/CsvSource.html), в котором наборы аргументов тестового метода передавать в виде csv-строки. Парсинг значений в соотетствии с типами аргументов осуществит сам **JUnit**:

```java
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RectangleTests {

  @ParameterizedTest
  @CsvSource({
      "5, 3, 'Rectangle {длина: 5, ширина: 3} (площадь: 15)'",
      "3, 5, 'Rectangle {длина: 5, ширина: 3} (площадь: 15)'",
  })
  public void toString(int sideA, int sideB, String expected) {
    // arrange
    Rectangle rect = new Rectangle(sideA, sideB);

    // act
    String actual = rect.toString();

    // assert
    assertEquals(expected, actual);
  }
}
```
