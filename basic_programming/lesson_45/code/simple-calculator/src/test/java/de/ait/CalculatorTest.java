package de.ait;

import jdk.jfr.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
  // Как называть тесты

  // имяТестируемогоМетода_сценарий_возвращаемоеЗначение

  //если хотим объединить по группам, можно сделать через вложенный класс

  @Nested
  @DisplayName("Тесты для метода sum")
  class ForSumTests {
    @Test
    public void sum_9Plus12_21Returned() {
      // конвенция AAA - Arrange Action Assert - структура теста
      // arrange - подготовили все нужное для работы метода
      double x = 9;
      double y = 12;
      // action - когда работает тестируемый метод
      double actual = Calculator.sum(x, y);
      // assert - когда сравниваем ожидаемое и действительное
      double expected = 21;
      assertEquals(expected, actual);
    }

    @Test
    public void sum_10Plus22_32Returned() {
      assertEquals(32, Calculator.sum(10, 22));
    }
  }

  @Nested
  @DisplayName("Тесты для метода pow")
  class ForPowTests{
    // один тест проверяет какой-то один сценарий
    @Test
    public void pow_2in2_4Returned() {
      assertEquals(4, Calculator.pow(2, 2));
    }

    @Test
    public void pow_3in3_27Returned() {
      assertEquals(27, Calculator.pow(3, 3));
    }

    @Test
    @DisplayName("pow(5, 2) == 25")
    public void pow_5in2_25Returned() {
      assertEquals(25, Calculator.pow(5, 2));
    }
  }


}