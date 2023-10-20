## Шаги относительно `EducationCenter`

1. Создать проект Maven проект
2. Подключить зависимости
3. Перенос кода с редактированием import-ов
   * `config`
   * `documentation`
   * `dto.StandardResponseDto`
   * `exceptions`
   * `validation`
   * `security`
4. Создать модель `User` (с подключенным plugin-ом JPA Buddy сгенерировать equals/hashCode) и репозиторий с методом поиска по email
5. Поправить `security` (все импорты)
6. Реализовать регистрацию
   * Скопировать `UsersApi` и убрать лишнее
   * Скопировать `NewUserDto` и `UserDto`
   * Скопировать контроллер
   * Скопировать сервис
7. Проверить Swagger
8. Написать/скопировать тесты