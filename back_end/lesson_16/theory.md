# Продолжение изучения Spring Security

## 01. Замечания

* Конфигурация Security в Spring-приложении сводится к тому, чтобы получить готовый бин `HttpSecurity`, донастроить его и на его основе сделать новый бин - `SecurityFilterChain`
* Важно: поскольку мы хотим минимизировать количество кода для настройки и понимания Spring Security, мы сделали одно допущение (оставили по-умолчанию):
  * Запрос `POST /login` уходит как обычная HTTP/HTML-форма, а не JSON.

## 02. Внесение определенных изменений в конфигурацию

* Для удобства сделали метод `fillResponse`
* Мы заметили, что после того, как мы делаем `login`, сервер отдает нам информацию от запроса, который до этого не был авторизован
  * Это не очень хорошее поведение, мы бы хотели, чтобы после `login` вам просто приходило сообщение в формате JSON о том, что вы успешно вошли в приложение
  * Аналогичным образом, мы бы хотели просто сообщить пользователю в JSON, если он ввел некорректный логин или пароль
  * Аналогично для `logout`
* Поскольку настройка `/login` и `/logout` выполняется не в контроллерах (а в фильтрах), то Swagger не может зацепить эти url-ы и показать их в документации
  * Чтобы их добавить, нам необходимо прописать это "ручками"
  * Добавить мой класс `OpenApiDocumentation`
  * Добавить бин `OpenAPI` в класс с `main`

* Ссылки для изучения структуры документации в формате Open API
  * [Полезное руководство](https://starkovden.github.io/introduction-openapi-and-swagger.html)
  * [Подробнее о спецификации](https://starkovden.github.io/openapi-tutorial-overview.html)
  * [Официальная документация](https://swagger.io/specification/)

## 03. Добавление новых функций

* Получение информации о себе на основе сессии с помощью аннотации `@AuthenticationPrincipal`
* Разграничение по ролям
  * `.antMatchers("/api/users").hasAnyAuthority("ADMIN")` - мы говорим, что запрос с этим URL может выполнять только пользовать с ролью `ADMIN`
  * `.antMatchers("/api/users").hasAnyAuthority("ADMIN", "USER")` - если разрешаете нескольким ролям
  * `.antMatchers("/api/users/**").hasAnyAuthority("ADMIN", "USER")` - если устанавливаете ограничение на все ENDPOINTS, которые начинаются с `api/users
  * `.antMatchers(HttpMethod.POST, "/api/users/**").hasAnyAuthority("ADMIN", "USER")` - разрешили отправлять POST-запросы на все URL-ы, которые начинаются с `api/users` только `ADMIN` и `USER`
* Более красивый способ разграничения по ролям:
  * `@PreAuthorize("hasAuthority('ADMIN')")` - данную аннотацию вешаем на метод контроллера (или можно на весь контроллер)

## 04. Настройка Swagger

![image](https://raw.githubusercontent.com/ait-tr/cohort25/main/back_end/lesson_16/img/1.png)

## 05. Автоконфигурация Spring

![image](https://raw.githubusercontent.com/ait-tr/cohort25/main/back_end/lesson_16/img/2.png)