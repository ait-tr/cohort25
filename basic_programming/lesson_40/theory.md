# Метод `equals()`

Сравнение объектов по умолчанию сравнивает ссылки.

Если вы создали собственный класс (например, деньги) и хотите научиться сравнивать его с другими объектами, то вам необходимо переопределить метод `public boolean equals(Object o)`:
```java
public class Money {

  private long amount;
  private String currency;

  public Money(double amount, String currency) {
    this.amount = Math.round(amount * 100);
    this.currency = currency;
  }

  @Override
  public String toString() {
    return String.format("%.2f %s", amount / 100.0, currency.toUpperCase());
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof Money money)) {
      return false;
    }
    return amount == money.amount && currency.equalsIgnoreString(money.currency);
  }
}
```

**Внимание!** Метод `equals` должен принимать аргумент `Object`!

При сравнении вам нужно самостоятельно проверить, можете ли вы сравнивать с экземплярами конкретного класса!

# Метод `hashCode()`

Метод `public int hashCode()` используется Java при поиске и хранении объекта в HashSet или для поиска исравнения ключей в HashMap.

Правила hashCode:

- одинаковые объекты (т.е. те, которые считает равными `equals()`) имеют одинаковый hashCode  
- разные объекты МОГУТ иметь одинаковый hashCode, тогда выполнется сравнение `equals()`   
- чем реже совпадает hashCode для неодинаковых объектов, тем лучше   

**Т.к. необходимо, чтобы для тех объектов, которые считает равными `equals()`, метод `hashCode()` также возвращал одинаковое значение,**
**при переопределении метода `equals()` вы должны переопределить метод `hashCode()`.**

Самой плохой реализацией `hashCode()` можно считать метод, который всегда возвращает одно и тоже знначение: 

```java
@Override
public int hashCode() {
  return 1;
}
```
Такая реализация приведдет к тому, что для всех объектов  `HashMap` и `HashSet` будет выполняться сравнение `equals()`, что сделает работу этих структур очень медленной.

Желательно, чтобы для разных объектов метод `hashCode()` возвращал разные значения.

Пример "грубой" реализации метода, консистентной с `equals()` для упомянутого выше класса `Money`:
```java
@Override
public int hashCode() {
  return (int) amount * currency.hashCode();
}
```

Пример усовершенствованной реализации, генерируемой Idea для старых версий Java:
```java
@Override
public int hashCode() {
  int result = (int) (amount ^ (amount >>> 32));
  result = 31 * result + currency.hashCode();
  return result;
}
```

Idea по запросу автоматически генерирует методы `equals()` и `hashCode()`:
```java
@Override
public boolean equals(Object o) {
  if (this == o) {
    return true;
  }
  if (!(o instanceof Money money)) {
    return false;
  }
  return amount == money.amount && currency.equals(money.currency);
}

@Override
public int hashCode() {
  return Objects.hash(amount, currency);
}
```

В большинстве случаев результат автоматической генерации вам полностью подойдёт.

Дополнительная информация про `hashCode()`:
- [Статья на JavaRush](https://javarush.com/groups/posts/2179-metodih-equals--hashcode-praktika-ispoljhzovanija)
- [Статья на Tproger](https://tproger.ru/articles/equals-hashcode-java/)
- [Статья на Baeldung (англ.)](https://www.baeldung.com/java-hashcode)
- Очень умными словами [на Википедии](https://ru.wikipedia.org/wiki/Хеш-функция)
