# Spring Security + доп. изменения

* `Aутентификация` - идентификация пользователя, кто ты?

* `Авторизация` - проверка прав пользователя, какие действия ты можешь выполнять?

* `Authentication` - объект, который хранит для каждого запроса информацию о пользователе и статусе его аутентификации.

* `SecurityContext` - информация о безопасности, которая ассоциирована с текущим потоком исполнения (Thread). Хранит объект Authentication.

* `SecurityContextHolder` - привязывает SecurityContext к текущему потоку исполнения. По умолчанию ThreadLocal - контекст безопосности доступен всем методам, исполняемым в рамках данного потока.

* Т.е. когда приходит запрос на сервер, сервер выделяет ему один поток из `Tomcat Thread Pool`
* Далее, SecurityContextHolder (на самом деле фильтры, но это не важно) смотрит текущую сессию и привязывает объект `Authentication` к текущему потоку исполнения
* Далее, когда запрос приходит в какой-либо контроллер или хендлер - он уже приходит с объектом аутентификации

## Тестирование безопасности

* Для защищенных endpoints нам нужно предварительно выполнить аутентификацию (через `/login`), чтобы в тестах получить нужные данные
* Для этого, мы заменим нашу реализацию `UserDetailsImpl` на другую - `InMemoryUserDetailsManager`
* `InMemoryUserDetailsManager` в явном виде проверяет, какой пользователь к нам пришел и возвращает объект `AuthenticatedUser` без обращения в базу данных
* Поскольку, у нас уже есть один бин `UserDetailsService`, то два таких бина будут вызывать конфликт
* Чтобы этот конфликт устранить, мы все организовали следующим образом:
  * Сделали отдельный конфигурационный класс `TestSecurityConfig` с бином на `userDetailsService` и профилем `test`
  * На бин `userDetailsService` повесили аннотацию `@Primary`, которая говорит, что если есть два бина, то нужно выбрать этот
  * В самом тестовом классе мы указали этот конфигурационный класс - `@SpringBootTest(classes = TestSecurityConfig.class)`
* Если запрос требует авторизации, просто указываем это с помощью аннотации `@WithUserDetails(value = "admin")`
* Важно - подключить зависимость `spring-security-test`

## Написание собственного валидатора

* Нужно создать аннотацию
* Нужно создать валидатор для этой аннотации
* Нужно повесить аннотацию на поле