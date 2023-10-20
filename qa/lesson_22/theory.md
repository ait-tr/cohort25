## WHITE-BOX testing(Техника тестирования белого ящика)
используется на уровне тестирования компонентов(т.н. модульного тестирования), но его также можно применять на любом другом уровне, используя различные модели ПО «белого ящика»

used at the component testing level, but can also be applied at any other level using various white box software models

**Statement coverage(Покрытие операторов)** 

включает выполнение всех операторов хотя бы один раз в исходном коде

involves executing all statements at least once in the source code

**Branch coverage(Покрытие ветвей)** 
также известно как покрытие решений(decision coverage) или покрытие всех границ(all-edges coverage) 

охватывает как истинные, так и ложные условия, маловероятные для покрытия операторов

covers both true and false conditions, unlikely to cover statements

[Презентация](https://docs.google.com/presentation/d/1yvwkvPDSZTZYUrMa7WFrPW8zpD-Zd3X3/edit?usp=share_link&ouid=116447005932578256378&rtpof=true&sd=true)

[Examples](https://drive.google.com/file/d/1c0YCDEvD6JcCvx-5mzau1yGRb6vkIwYM/view?usp=share_link)

## Combinatorics(Комбинирование данных)

Основные методы комбинирования:

**Полный перебор значений**

• Тестирование всех возможных комбинаций всех значений всех параметров

• Максимальное покрытие

• Максимум тестов

**Метод минимальных проверок**

• По одному значению каждого параметра использовано хотя бы в одном тест-кейсе

• Минимальное покрытие

• Минимум тестов

**Атомарная проверка**

• Тест-кейсы строятся на основе выбора всех базовых значений, кроме одного, которое изменяется

• Легко локализуемое покрытие

**Pairwise**

• Вместо проверки всех комбинаций - выбираем уникальные пары всех параметров

• Согласно исследованиям компании IBM 97% ошибок в ПО возникает при взаимодействии всего двух значений

Pairwise online https://pairwise.teremokgames.com/

Allpairs download https://www.satisfice.com/download/allpairs

**Алгоритм применения техники**

- Определить переменные
- Определить их значения
- Оптимизировать значения
- Описать условия и зависимости
- Построить тестовую таблицу

[Презентация](https://docs.google.com/presentation/d/1GhpqeK3QIi6w3Bvju3ToKG8E1LTRzS9M/edit?usp=share_link&ouid=116447005932578256378&rtpof=true&sd=true)

[Examples](https://docs.google.com/spreadsheets/d/1ZoTZuTH4GqYpHGfwF47vXCjCeabA7BK6/edit?usp=share_link&ouid=116447005932578256378&rtpof=true&sd=true)
