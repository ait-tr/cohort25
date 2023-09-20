# Повторение

## 00. Теория

* `@Data` - геттеры, сеттеры, equals, hashCode

### ORM

* `Object Relational Mapping`/`ORM` - подход, при котором объектно-ориентированный код автоматически отображается в реляционные отношения
  * На основе класса была создана SQL-таблица
* `Java Persistence API`/`JPA` - набор аннотаций, которые позволяют реализовать ORM в Java (`javax.persistence`)
  * `@Entity` - показывает, что на основе класса нужно создать таблицу (грубо говоря).
  * `@Id` - показывает, что поле является первичным ключом в базе данных (идентификатором, `primary key`)
  * `@Column` - ставим, если хотим дать какие-либо специфичные настройки для поля, которая станет столбцом в БД
    * `nullable = false` - задает атрибут `NOT NULL` для колонки
    * `length = 1000` - задает максимальную длину для колонки, которая хранит текст
  * Если мы не указываем `@Column` над полем, то он для строк дает значение по умолчанию 255, `NOT NULL` не ставится
  * `@GeneratedValue(strategy = GenerationType.IDENTITY)` - говорит, что значение столбца генерируется автоматически
  * `@Enumerated(value = EnumType.STRING)` - говорит, что enum будет храниться как строка, по умолчанию - как число:
    * `DRAFT` -> `0`
    * `PUBLISHED` -> `1`
* `Hibernate` - ORM-фреймворк, генерирует SQL-код на основе аннотаций JPA
* `JpaRepository` - интерфейс, часть фреймворка `Spring Data JPA`, содержит базовые операции над моделями
  * позволяет избежать написания большей части базовых запросов

## 01. Создание нового проекта

* New Project
* Spring Initializr
  * Language: `Java`
  * Type : `Maven`
* Group, Artifact, Package Name
* Spring Boot: `2.7.15`
* Dependencies
  * Developer Tools
    * `Lombok`
  * Web
    * `Spring Web`
  * SQL
    * `Spring Data JPA`
    * `H2 Database`
* Удаляем папки `static` и `templates`

## 02. Настройка базы данных

* В `resources` в `application.properties` прописываем подключение

## 03. Прописываем архитектуру проекта с помощью пакетов

* `controllers` - обработка HTTP-запросов
* `models` - модели предметной области
* `repositories` - классы для работы с хранилищем (базой данных)
* `services` - бизнес-логика

## 04. Определяемся с задачей и создаем модель предметной области

### Пример задачи

### Описание

* Реализовать endpoints для работы со списком курсов
  * Добавление курса
  * Обновление курса
  * Получение курса по ID
  * Получение всех курсов
  * Удаление курса
  * Публикация курса

* При создании курса у него должно быть состояние `DFAFT` (черновик)
* При публикации курса у него будет состояние `PUBLISHED`

### Примеры запросов и ответов

#### Добавление курса

#### Запрос

```
POST /api/courses
```

##### Тело запроса

```json
{
  "title": "Новый курс",
  "beginDate": "02.02.2022",
  "endDate": "02.02.2023",
  "description": "Описание нового курса",
  "price": 100.0
}
```

#### Ответ

* Статус `201 CREATED`

##### Тело ответа

```json
{
  "id": 1,
  "title": "Новый курс",
  "beginDate": "02.02.2022",
  "endDate": "02.02.2023",
  "description": "Описание нового курса",
  "price": 100.0,
  "state": "DRAFT"
}
```

### Создание моделей

* Создаем модель с полями
* Помечаем всеми необходимыми аннотациями `lombok`
* Помечаем всеми необходимыми аннотациями `JPA` (для работы с БД, пакет `javax.persistence`)

## 05. Реализация endpoint-а

* Создаем контроллер (если его нет)
* Создаем соответствующий метод (в сервисе)
* Создаем репозиторий
* Вызываем соответствующий метод репозитория в сервисе
* Проверяем через `requests.http`
* Пишем тест (не забываем про импорты)

```
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
```