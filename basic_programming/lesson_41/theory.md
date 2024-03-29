## Math.random()

Метод Math.random() – в Java используется для генерации случайного числа в диапазоне от 0.0 до 1.0.  
Различные диапазоны могут быть достигнуты с помощью арифметики.

Формула для генерации числа в диапазоне от min до max включительно:   

```java
int min = 3;
int max = 10;
int num = (int) (min + Math.random() * (max - min + 1));
```

## Класс Random

Класс java.util.Random представляет собой генератор псевдослучайных чисел.

### Класс представлен двумя конструкторами

- Random() - создаёт генератор чисел, использующий уникальное начальное число
- Random(long seed) - позволяет указать начальное число вручную
Так как класс создаёт псевдослучайное число, то задав начальное число, вы определяете начальную точку случайной последовательности. И будете получать одинаковые случайные последовательности. Чтобы избежать такого совпадения, обычно используют второй конструктор с использованием текущего времени в качестве инициирующего значения.

### Методы:

- boolean nextBoolean() - возвращает следующее случайное значение типа boolean
- void nextBytes(byte[] buf) - заполняет массив случайно созданными значениями
- double nextDouble() - возвращает следующее случайное значение типа double
- float nextFloat() - возвращает следующее случайное значение типа float
- synchronized double nextGaussian() - возвращает следующее случайное значение гауссова случайного числа, т.е. значения, центрированное по 0.0 со стандартным отклонением в 1.0 (кривая нормального распределения)
- int nextInt(int n) - возвращает следующее случайное значение типа int в диапазоне от 0 до n
- int nextInt() - возвращает следующее случайное значение типа int
- long nextLong() - возвращает следующее случайное значение типа long
- synchronized void setSeeD(long seed) - устанавливает начальное значение
### Пример для вывода случайного числа.


```java
final Random random = new Random();

public void onClick(View v) {
mInfoTextView.setText(String.valueOf(random.nextInt()));
}
```
Случайные числа часто используются в играх. Допустим, мы хотим вывести случайные числа от 1 до 6 при бросании игрального кубика. Попробуем.


```java
mInfoTextView.setText(String.valueOf(random.nextInt(6)));
```
При проверке вы заметите две нестыковки. Во-первых, иногда выпадает число 0, которого нет на кубике, а во-вторых никогда не выпадает число 6. Когда вы помещаете число в параметр метода, то это означает, что выпадают числа в диапазоне от 0 до указанного числа, которое в этот диапазон не входит. Если вы будете использовать число 7, то шестёрка станет выпадать, но по-прежнему будет выпадать число 0. Поэтому пример следует немного отредактировать.


```java
mInfoTextView.setText(String.valueOf(random.nextInt(6) + 1));
```
Для генерации 10 чисел типа int используйте код:

```java
String result = "";

for(int i = 0; i < 10; i++){
  result += String.valueOf(myRandom.nextInt()) + "\n";
}
mInfoTextView.setText(result);
```

Генерация в определённом интервале
Нужны случайные числа от 100 до 200? Пишем код.

```java
int min = 100;
int max = 200;
int diff = max - min;
Random random = new Random();
int i = random.nextInt(diff + 1);
i += min;
```