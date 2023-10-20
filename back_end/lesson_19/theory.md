## Spring Data Jpa Methods

### Возвращаемый тип

* Примитивный или оберточный тип для запросов, которые возвращают какое-либо одно значение

```
boolean existsByEmail(String email);

int countByRole(User.Role role);
```

* Можно указывать `Optional<T>` для запросов, которые возвращают единственный объект:

```
Optional<User> findByEmail(String email);
```

* Можно указывать тип `<T>` для запросов, которые возвращают единственный объект
  * Но если такой объект не будет найден - вернется null
  * Предпочтительнее `Optional`, потому что он в явном виде вас обязывает проверить null-ситуацию

```
Course findByTitle(String title);
```

* Можно указать коллекцию/итератор/поток любого типа, если запрос подразумевает возвращение нескольких объектов:

```
Set<User> findAllByCoursesContainsOrderById(Course course);
List<User> findAllByCoursesContainsOrderById(Course course);
Collection<User> findAllByCoursesContainsOrderById(Course course);
Iterator<User> findAllByCoursesContainsOrderById(Course course);
Stream<User> findAllByCoursesContainsOrderById(Course course);
```

### Типы запросов

* `exists...By` - проверяет существование по какому-либо условию (возвращает `boolean`)
* `count...By` - возвращает количество записей по какому-либо условию (возвращает `int`)
* `delete...By/remove...By` - удаляют по какому-либо условию (могут быть либо `void`, либо вернуть количество удаленных записей - `int`)

```
void deleteByRole(User.Role role);
```

* `find/read/get/query/search/stream` - запрос на чтение из базы, как правило, возвращает либо коллекцию, либо один объект.

### Комбинации условий (что мы пишем после by)

* Мы можем указывать поля через `and`

```
Optional<Lesson> findByCourseAndId(Course course, Long lessonId);
```

* Можно указывать через `or`

```
List<Lesson> findAllByDayOfWeekOrName(DayOfWeek dayOfWeek, String name);
```

* Можно применить `After/IsAfter` и `Before/IsBefore` как правило применяют к датам и времени:

```
List<Course> findAllByBeginDateAfter(LocalDate date);
```

* Для полей, которые представляют собой коллекции можно применить `Containing/IsContaining/Contains`:
  * Тогда вернутся все объекты, поля-коллекции которых содержат какой-либо другой объект

```
Set<User> findAllByCoursesContainsOrderById(Course course);
```

* Если значение поля должно лежать в каком-либо диапазоне, можно использовать `Between`

```
List<Lesson> findAllByStartTimeBetween(LocalTime from, LocalTime to);
```


* `EndsWith` или `StartsWith`, чтобы проверить, что какая-то строка заканчивается или начинается с определенного значения:

```
List<Lesson> findAllByNameStartsWith(String prefix);
```

* Для некоторых типов полей можно применять слова `IsFalse`, `IsTrue`, `IsNull`, `IsNotNull`, `IsEmpty`, `IsNotEmpty`: 

```
List<User> findAllByFirstNameIsNotNull(); 
```

* Для числовых полей можно применять слова `IsGreaterThan`, `IsGreaterThanEqual`, `IsLessThan`, `IsLessThanEqual`:

```
List<Course> findAllByPriceIsGreaterThan(double price);
```

* Можно в качестве параметра передать коллекцию и использовать in, чтобы проверить, а есть ли значение этого поля в списке?
  * Если нужно, чтобы значение поля не содержалось в списке - `IsNotIn`
```
List<Lesson> findAllByDayOfWeekIn(List<DayOfWeek> days);
```

### Методы для составных запросов по характеристикам подсущностей

* Используя символ `_` мы можем обращаться к подсущностям и их полям.
  * Например, получить все уроки, у которых курс опубликован

```
List<Lesson> findAllByCourse_State(Course.State state);
```

* Например, хотим получить студентов, которые находятся в курсе, у которого дата начала в определенном диапазоне

```
List<User> findAllByCourses_BeginDateBetween(LocalDate from, LocalDate to);
```

## 02. Собственные запросы на JPQL в репозиториях

* JPQL - Java Persistence Query Language - язык запросов, аналог SQL, который позволяет описывать зарос с точки зрения классов, а не таблиц.
* В `JpaRepository` их можно писать с помощью аннотации `@Query`

### Рассмотрим на примере задачи:

* Получение всех опубликованных курсов

* Пример endpoint-а:

```
GET /api/courses?state=PUBLISHED

GET /api/courses/published
```

* Реализация метода в репозитории на основе JQL:

```
@Query("select course from Course course where course.state = 'PUBLISHED'")
List<Course> findAllPublishedCourses();
```

### Рассмотрим еще один пример

* Получить аккаунты, которые включены в опубликованные курсы

```
/users/byCourses?state=PUBLSHED
```

* Реализация метода в репозитории на основе JPQ:

```
@Query(value = "select user from User user " +
            "           join user.courses course " +
            "               where course.state = 'PUBLISHED'")
List<User> findAllByCoursesPublished();
```

### И еще один пример

* Получить студентов, у которых все курсы еще не начались

### Не рассматриваем:

* `Near`
* `Within`
* `Regex`

```
courses/{id}/lessons/{id}/types

/lessons/{id}/types
```

## Пагинация

* Если данных в бд очень много, но получать весь этот массив информации не очень хочется
* `limit` - SQL-команда, которая ограничивает выборку
* `offset` - сдвиг выборки
* `limit n offset n * m, где m - номер страницы, n - размер страницы`
* Если вам нужна пагинация в методе, который вы сделали сами, просто при объявлении этого метода репозитории укажите первым параметром `Pageable`


## Top, First, Distinct

* Позволяют получить кусок выборки (примитивная пагинация

```
List<User> findFirst4ByOrderByIdDesc();
```

### Рассмотреть варианты

* `Top, First, Distinct`
* `no session`, `toString/equals/hashCode` в моделях
* `Like`/`IgnoreCase`