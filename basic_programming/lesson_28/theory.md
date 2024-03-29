# Множество (`Set`)
Ссылка на презентацию: [ссылка](https://github.com/ait-tr/cohort25/blob/main/basic_programming/lesson_28/hashSet.pdf)

`Set` – это множество, набор ненумерованных (и обычно неупорядоченных) объектов. Главная особенность `Set` – в нем только уникальные объекты, т.е. они все разныe. Вот что с ним можно делать:

| Операция | Методы |
| --- | --- |
| Добавлять элемент(ы) | `add()`, `addAll()` |
| Удалять элемент(ы) | `remove()`, `removeAll()` |
| Очистить множество (удалить все элементы) | `clear()` |
| Проверять, есть ли элемент(ы) | `contains()`, `containsAll()` |
| Узнать размер | `size()` |

**Внимание!** В множестве **не бывает индексов**, и его нельзя "отсортировать"!

Существует несколько разновидностей множест, мы будем использовать `HashSet`.

Создание нового множества выглядит так:
```java
// Set<Тип> название = new HashSet<>();
Set<Integer> numbers = new HashSet<>();
```
Типы содержимого указываются так же, как и в `List` – никаких примитивных типов, только классы-"обёртки".
