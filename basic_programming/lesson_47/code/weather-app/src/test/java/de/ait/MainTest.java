package de.ait;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static de.ait.Main.isValidLogin;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MainTest {
  @Nested
  @DisplayName("isEven tests")
  class ForIsEven {
    @Test
//  @DisplayName("isEven(3) -> false")
    public void isEven_3_FalseReturned() {
      assertFalse(Main.isEven(3));
    }

    @ParameterizedTest
//  @DisplayName("isEven(<even>) -> true")
    @ValueSource(ints = {2, 6, 8, 64, 122, 800})
    public void isEven_even_TrueReturned(int number) {
      assertTrue(Main.isEven(number));
    }

    @ParameterizedTest
//  @DisplayName("isEven(<odd>) -> false")
    @ValueSource(ints = {11, 19, 117717, 25, 97})
    public void isEven_odd_FalseReturned(int x) {
      assertFalse(Main.isEven(x));
    }
  }

  @Nested
  @DisplayName("isValid tests")
  class ForIsValid {
    @ParameterizedTest
    @ValueSource(strings = {"asd", "adsa@", "asdasdasdasdasdasdasddas"})
    public void isValidLogin_test1(String login) {
      assertFalse(Main.isValidLogin(login));
    }
    @ParameterizedTest
    @ValueSource(strings = {"asdasdasdas@mail.ru", "adsada@gmail.de", "asdasdad@yandex.com"})
    public void isValidLogin_test2(String login) {
      assertTrue(isValidLogin(login));// вызвали метод без слова nested.example01.Main
      // это возможно благодаря import static de.ait.nested.example01.Main.isValidLogin;
    }

  }
  @Nested
  @DisplayName("getRectangleArea tests")
  class ForGetRectangleArea{
    @ParameterizedTest
    @CsvSource({
        "4, 5, 'Прямоугольник с площадью 20'",
        "10, 10, 'Прямоугольник с площадью 100'",
        "2, 3, 'Прямоугольник с площадью 6'"
    })
    public void getRectangleArea_test1(int a, int b, String message){
      assertEquals(
          message,
          Main.getRectangleArea(a, b)
      );
    }
  }
}