package de.ait;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeatherTest {
  @ParameterizedTest
  @CsvSource({
      "-30, 'холодно'",
      "0, 'холодно'",
      "5, 'свежо'",
      "10, 'свежо'",
      "15, 'тепло'",
      "16, 'тепло'",
      "20, 'тепло'",
      "30, 'жарко'",
  })
  public void describeTemperature_test1(int temperature, String description) {
    assertEquals(
        description,
        Weather.describeTemperature(temperature)
    );
  }
}