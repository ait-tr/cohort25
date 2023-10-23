## Отправка email по почте

![image](https://raw.githubusercontent.com/ait-tr/cohort25/main/back_end/lesson_21/img/1.png)

## 00. Замечания и определения

* Транзакция - последовательность операций, которая должна выполняться либо полностью, либо не выполняться вообще
* На уровне БД реализуется с помощью команд `BEGIN` - начало транзакции, `COMMIT` - фиксация транзакции, `ROLLBACK` - откат изменений
* На уровне Spring-приложения можно использовать аннотацию `@Transactional`

## 01. Создание поля State

* `State` будет показывать текущее состояние пользователя
  * `NOT_CONFIRMED` - не подтвержден
  * `CONFIRMED` - подтвержден
  * `DELETED` - удалил свой аккаунт
  * `BANNED` - забанен администратором
* Также нужно обработать `state` пользователя в `AuthenticatedUser`
* Предусмотреть состояние пользователя по-умолчанию при регистрации `NOT_CONFIRMED`

## 02. Реализовать функционал для создания ссылки подтверждения регистрации

* Создать модель `ConfirmationCode`
* Добавить зависимость в `pom.xml` - `spring-boot-starter-mail`
* Добавить нужные свойства в `applicaiton.yml`
* Реализовать класс `TemplateProjectMailSender`, который является оберткой над `JavaMailSender`
* На метод `send` класса `TemplateProjectMailSender` нужно повесить `@Async`, чтобы этот метод выполнялся в другом потоке (треде)
* В классе с mail-методом поставить аннотацию `@EnableAsync`

## Важные ссылки

* [Как получить пароль приложения](https://help.case.one/2022/07/11/%D0%BA%D0%B0%D0%BA-%D0%BF%D0%BE%D0%BB%D1%83%D1%87%D0%B8%D1%82%D1%8C-%D0%BF%D0%B0%D1%80%D0%BE%D0%BB%D1%8C-%D0%BF%D1%80%D0%B8%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D1%8F-google/)
* [Получение пароля для вашего аккаунта](https://myaccount.google.com/apppasswords)
* [В целом про работу с SMTP Gmail](https://kinsta.com/blog/gmail-smtp-server/)