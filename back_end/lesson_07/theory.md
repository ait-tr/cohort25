## 01. Подключение базы данных

1. Удаление users.txt
2. Удаляем в application.properties `users.file-name`
3. В repositories удаляем `UsersRepositoryFileImpl`

## 02.H2 база данных

![image](https://raw.githubusercontent.com/ait-tr/cohort25/main/back_end/lesson_07/img/1.png)

* H2 - это минимальная СУБД, как правило, используется только для тестирования, потому что не очень хорошо работает с большими данными
* Аналог MySQL, PostgreSQL, OracleDB
* Данные может хранить в оперативной памяти и в файле

## 03. Подключение базы данных в Spring Boot приложении

* Подключить зависимости в `pom.xml`:

```xml

<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <version>2.2.222</version>
    <scope>runtime</scope>
</dependency>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

* Достаточно указать настройки в `application.properties`
* Spring Boot умеет сам подключаться по этим настройкам к базе
* Если мы хотим хранить данные в оперативной памяти (т.е. база будет очищаться после перезапуска приложения)

```
spring.datasource.url=jdbc:h2:mem:shop_db
```

* `jdbc` - протокол подключения к базам данных в Java
* `h2` - тип базы данных
* `mem` - показывает, что база будет размещаться в оперативной памяти
* `shop_db` - название базы данных

* Если мы хотим хранить данные в файле, то нужно указать URL таким образом:

```
jdbc:h2:file:~/databases/shop_db;AUTO_SERVER=TRUE
```

* `file` - храним данные в файле
* `~/databases` - название папки, где мы храним данные (в папке пользователя в подпапке `databases`)
* `shop_db` - название базы
* `AUTO_SERVER=TRUE` - чтобы можно было подключаться из других приложений

## 04. Дополнительные классы и интерфейсы

* `DataSource` - объект, который содержит подключение к базе данных, описанной в `application.properties`

## 05. Тезисы занятия

* Вместо работы с обычным файлом, мы подключили СУБД H2, которая умеет хранить данные в памяти и в файле.
  * Добавили зависимости на `h2` и `spring-boot-data-jpa` в pom.xml
  * Заполнили файл `application.properties`
  * Создали папку `databases`, в которой будет лежать база данных
  * После запуска приложения, наша БД появилась в папке `databases`
  * Подключились к базе данных через IDEA
  * Теперь мы можем смотреть консоль базы и отправлять через нее
  * А также можем смотреть содержимое таблиц
  * Если какие-то обновления не видны, нажмите на две круглые стрелочки

![image](https://raw.githubusercontent.com/ait-tr/cohort25/main/back_end/lesson_07/img/2.png)